package com.emma.SQLModelFactory

import org.apache.spark.sql.types._
import org.apache.spark.sql.Row

import java.sql.Timestamp

class ArmFlow extends Base {
 
  def parseFromLogFile: StructType = {
   
      return StructType(Array(StructField("GameId", LongType, true), StructField("AccountType", LongType, true),
                              StructField("WorldId", LongType, true), StructField("dtEventTime", StringType, true),
                              StructField("iEventId", LongType, true), StructField("vVersionId", StringType, true),
                              StructField("vUin", StringType, true), StructField("iRoleId", LongType, true),
                              StructField("vRoleName", StringType, true), StructField("iRoleJob", LongType, true),
                              StructField("iRoleGender", LongType, true), StructField("iRoleLevel", LongType, true),
                              StructField("iRoleVipLevel", LongType, true), StructField("iRoleReputationLevel", LongType, true),
                              StructField("vRoleElse1", StringType, true), StructField("vRoleElse2", StringType, true),
                              StructField("vClientIP", StringType, true), StructField("iArmId", LongType, true), 
                              StructField("iStar", LongType, true), StructField("iLevel", LongType, true), 
                              StructField("iArmType", LongType, true), StructField("iArmNum", LongType, true), 
                              StructField("iArmGuide", LongType, true), StructField("jEquipProperty", DataTypes.createMapType(StringType, LongType), true), 
                              StructField("iFlowDirection", LongType, true), StructField("iAction", LongType, true))) 
                      
  }

  def toRow(line: Array[String]): Row = {
    
      val gameId = line(0).toLong
      val accountType = line(1).toLong
      val worldId = line(2).toLong
      val dtEventTime = line(3)
      val iEventId = line(4).toLong
      val vVersionId = line(5)
      val vUin = line(6)
      val iRoleId = line(7).toLong
      val vRoleName = line(8)
      val iRoleJob = line(9).toLong
      val iRoleGender = line(10).toLong
      val iRoleLevel = line(11).toLong
      val iRoleVipLevel = line(12).toLong
      val iRoleReputationLevel = line(13).toLong
      val vRoleElse1 = line(14)
      val vRoleElse2 = line(15)
      val vClientIP = line(16)
      val iArmId = line(17).toLong
      val iStar = line(18).toLong
      val iLevel = line(19).toLong
      val iArmType = line(20).toLong
      val iArmNum = line(21).toLong
      val iArmGuide = line(22).toLong
      val jEquipProperty = line(23).substring(1, line(23).length()-1)
                                   .split(",")
                                   .map(_.split(":"))
                                   .map { case Array(k, v) => (k.substring(1, k.length-1), v.toLong)}
                                   .toMap
      val iFlowDirection = line(24).toLong
      val iAction = line(25).toLong
      
      return Row(gameId, accountType, worldId, dtEventTime, iEventId, vVersionId, vUin, iRoleId, vRoleName, iRoleJob, iRoleGender, iRoleLevel,
                 iRoleVipLevel, iRoleReputationLevel, vRoleElse1, vRoleElse2, vClientIP, iArmId, iStar, iLevel, iArmType, iArmNum, iArmGuide, 
                 jEquipProperty, iFlowDirection, iAction)
    
  }
}