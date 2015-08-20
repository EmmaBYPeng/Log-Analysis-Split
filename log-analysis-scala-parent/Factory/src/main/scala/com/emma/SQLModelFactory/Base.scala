package com.emma.SQLModelFactory

import org.apache.spark.sql.types._
import org.apache.spark.sql.Row

abstract class Base extends Serializable {
  def parseFromLogFile: StructType
  def toRow(line: Array[String]): Row
}