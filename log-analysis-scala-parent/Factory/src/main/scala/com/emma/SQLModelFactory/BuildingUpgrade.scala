package com.emma.SQLModelFactory
import org.apache.spark.sql.types._

/**
 * @author user
 */
class BuildingUpgrade extends Base {
  
  def parseFromLogFile: StructType = {
    return new StructType(Array(StructField("GameId", LongType, true), StructField("AccountType", LongType, true),
                                StructField("WorldId", LongType, true), StructField("dtEventTime", TimestampType, true),
                                StructField("iEventId", LongType, true), StructField("vVersionId", StringType, true),
                                StructField("vUin", StringType, true), StructField("iRoleId", LongType, true),
                                StructField("iRoleName", StringType, true), StructField("iRoleJob", LongType, true),
                                StructField("iRoleGender", LongType, true), StructField("iRoleLevel", LongType, true),
                                StructField("iRoleVipLevel", LongType, true), StructField("iRoleReputationLevel", LongType, true),
                                StructField("vRoleElse1", StringType, true), StructField("vRoleElse2", StringType, true),
                                StructField("iRoleExperience", LongType, true), StructField("iRoleSword", LongType, true),
                                StructField("iPartyId", LongType, true), StructField("vPartyName", StringType, true),
                                StructField("iPartyLevel", LongType, true), StructField("iBuildingParty", LongType, true),
                                StructField("iUpgradeBuildingId", LongType, true), StructField("vUpgradeBuildingName", StringType, true),
                                StructField("iBuildingLevel", LongType, true), StructField("iUpgradeCostParty", LongType, true),
                                StructField("iPartyLeftMoney", StringType, true), StructField("iPartyLeftPolicy", LongType, true),
                                StructField("iCostTime", LongType, true), StructField("dtEventEndTime", TimestampType, true)
                                ))
  }
}