package com.emma.SQLModelFactory

import java.sql.Timestamp

/**
 * @author user
 */
class ArmFlow(iGameId:String, iAccountType: String, iWorldId: String, dtEventTime: String, iEventId: String, vVersionId: String, 
              vUin: String, iRoleId: String, vRoleName: String, iRoleJob: String, iRoleGender: String, iRoleLevel: String,
              iRoleVipLevel: String, iRoleReputationLevel: String, vRoleElse1: String, vRoleElse2: String, vClientIP: String, 
              iArmId: String, iStar: String, iLevel: String, iArmType: String, iArmNum: String, iArmGuide: String, jEquipProperty: String,
              iFlowDirection: String, iAction: String) extends Base {
  var gameId = iGameId.toLong 
  var accountType = iAccountType.toLong
  var worldId = iWorldId.toLong
  var eventTime = Timestamp.valueOf(dtEventTime)
  var eventId = iEventId.toLong
  var versionId = vVersionId
  var uin = vUin
  var roleId = iRoleId.toLong
  var roleName = vRoleName
  var roleJob = iRoleJob.toLong
  var roleGender = iRoleGender.toLong
  var roleLevel = iRoleLevel.toLong
  var roleVipLevel = iRoleVipLevel.toLong
  var roleReputationLevel = iRoleReputationLevel.toLong
  var roleElse1 = vRoleElse1
  var roleElse2 = vRoleElse2
  var clientIP = vClientIP
  var armId = iArmId.toLong
  var star = iStar.toLong
  var level = iLevel.toLong
  var armType = iArmType.toLong
  var armNum = iArmNum.toLong
  var armGuide = iArmGuide.toLong
  var equipProperty = jEquipProperty
  var flowDirection = iFlowDirection.toLong
  var action = iAction.toLong
  
  def parseFromLogFile(args: Array[String], GameId: String, AccountType: String, WorldId: String): ArmFlow =
    new ArmFlow(GameId, AccountType, WorldId, args(1),args(2),args(3),args(4),args(5),args(6),args(7),args(8),args(9),args(10),args(11),
                args(12),args(13),args(14),args(15),args(16),args(17),args(18),args(19),args(20),args(21),args(22),args(23))
  
  def canEqual(that: Any): Boolean = {
    if (that.isInstanceOf[ArmFlow]) {
      return true
    } else {
      return false
    }
  }
  
  def productArity: Int = {
    return 26
  }
  
  def productElement(n: Int): Any = {
    n match {
      case 0 => return gameId
      case 1 => return accountType
      case 2 => return worldId
      case 3 => return eventTime
      case 4 => return eventId
      case 5 => return versionId
      case 6 => return uin
      case 7 => return roleId
      case 8 => return roleName
      case 9 => return roleJob
      case 10 => return roleGender
      case 11 => return roleLevel
      case 12 => return roleVipLevel
      case 13 => return roleReputationLevel
      case 14 => return roleElse1
      case 15 => return roleElse2
      case 16 => return clientIP
      case 17 => return armId
      case 18 => return star
      case 19 => return level
      case 20 => return armType
      case 21 => return armNum
      case 22 => return armGuide
      case 23 => return equipProperty
      case 24 => return flowDirection
      case 25 => return action
    }
  }
  
}