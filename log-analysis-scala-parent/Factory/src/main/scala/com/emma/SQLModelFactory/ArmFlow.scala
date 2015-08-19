package com.emma.SQLModelFactory

import org.apache.spark.sql.types._

class ArmFlow extends Base {
 
  def parseFromLogFile: StructType = {
    return StructType(Array(StructField("GameId", LongType, true), StructField("AccountType", LongType, true),
                            StructField("WorldId", LongType, true), StructField("dtEventTime", TimestampType, true),
                            StructField("iEventId", LongType, true), StructField("vVersionId", StringType, true),
                            StructField("vUin", StringType, true), StructField("iRoleId", LongType, true),
                            StructField("vRoleName", StringType, true), StructField("iRoleJob", LongType, true),
                            StructField("iRoleGender", LongType, true), StructField("iRoleLevel", LongType, true),
                            StructField("iRoleVipLevel", LongType, true), StructField("iRoleReputationLevel", LongType, true),
                            StructField("vRoleElse1", StringType, true), StructField("vRoleElse2", StringType, true),
                            StructField("vClientIP", StringType, true), StructField("iArmId", LongType, true), 
                            StructField("iStar", LongType, true), StructField("iLevel", LongType, true), 
                            StructField("iArmType", LongType, true), StructField("iArmNum", LongType, true), 
                            StructField("iArGuide", LongType, true), StructField("jEquipProperty", StringType, true), 
                            StructField("iFlowDirection", LongType, true), StructField("iAction", LongType, true)))
  }

}