package com.emma.SQLModelFactory

import org.apache.spark.sql.types._

class AccountLogin extends Base {
  
  def parseFromLogFile: StructType = {
    return StructType(Array(StructField("GameId", LongType, true), StructField("AccountType", LongType, true), 
                            StructField("WorldId", LongType, true), StructField("dtEventTime", TimestampType, true), 
                            StructField("iEventId", LongType, true), StructField("vVersionId", StringType, true), 
                            StructField("vUin", StringType, true), StructField("vClientIp", StringType, true),
                            StructField("vZoneId", StringType, true), StructField("dtCreateTime", TimestampType, true), 
                            StructField("iFeeFlag", LongType, true), StructField("vLoginWay", StringType, true)))
  }
}