package com.emma.Split

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.SQLContext

import scala.collection.JavaConverters._

import com.emma.Tools.ReadConfigurationFile
import com.emma.SQLModelFactory.Base

/**
 * @author user
 */
object Main {
  
  def main(args: Array[String]): Unit = {
    var path: String = null
    var date: String = null
    var iGameId: String = null
    var iWorldId: String = null
    var iAccountType: String = null
    var nameNode: String = null
    var time: String = ""
    
    var i = 0
    while (i < args.length) {
      if (!args(i).contains("--")) {
        println("Wrong Parameter\n --help for all parameters")
        return
      }
      
      if (args(i).contains("help")) {
        println("--HDFS   Name Node  NOT NULL\n"
                        + "--DATE Index Field Date  NOT NULL\n" + "--GAMEID Index Filed Gameid\n"
                        + "--WORLDID Index Filed WORLDID\n"
                        + "--ACCOUNTTYPE Index Filed ACCOUNTTYPE\n"
                        + "--TIME Hours of the Field\n"
                        + "--CONF configuration files for javabean class")
        return
      }
      
      args(i) match {
        case "--HDFS" => nameNode = args(i+1)
        case "--DATE" => date = args(i+1)
        case "--GAMEID" => iGameId = args(i+1)
        case "--WORLDID" => iWorldId = args(i+1)
        case "--ACCOUNTTYPE" => iAccountType = args(i+1)
        case "--TIME" => time = args(i+1)
        case "--CONF" => path = args(i+1)
      }     
      
      i += 2
    }
    
    val targetFile = nameNode + "/LOG/" + iGameId + "/" + iAccountType + "/" + iWorldId + "/" + date + "/" + time + "/*"
    val dstPath = "/LOG/" + iGameId + "/" + iAccountType + "/" + iWorldId + "/" + date + "/" + time + "/"
  
    val conf = new SparkConf().setAppName("Log Filter")
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)
    
    try {
      val logLines = sc.textFile(targetFile, 4)      
      val hadoopFile = logLines.map { line => 
        val temp = (new LogLineSplit()).parseLog(line)
        (temp.keyName, temp.lineValues)
      }
      
      val list = ReadConfigurationFile.ReadSplitConfiguration(path).asScala.toList
      for (l <- list) {
        println("emma: " + l(0) + " " + l(1))
        val c = Class.forName(l(0))
        val inst = c.newInstance().asInstanceOf[Base]
        val sp = new SaveParquet[Base](inst)
        sp.logToParquet(sqlContext, hadoopFile, l(1), dstPath, iGameId, iAccountType, iWorldId)
      }
    } catch {
      case e: Throwable => e.printStackTrace()
    }
    
  } 
}