package com.emma.SQLModelFactory

import java.sql.Timestamp

class AccountLogin(iGameId: String, iAccountType: String, iWorldId: String, dtEventTime: String, iEventId: String,
                   vVersionId: String, vUin: String, vClientIp: String, vZoneId: String, dtCreateTime: String,
                   iFeeFlag: String, vLoginWay: String) extends Base with Product {
  
  var gameId = iGameId.toLong 
  var accountType = iAccountType.toLong
  var worldId = iWorldId.toLong
  var eventTime = Timestamp.valueOf(dtEventTime)
  var eventId = iEventId.toLong
  var versionId = vVersionId
  var uin = vUin
  var clientIp = vClientIp
  var zoneId = vZoneId
  var createTime = Timestamp.valueOf(dtCreateTime)
  var feeFlag = iFeeFlag.toLong
  var loginWay = vLoginWay
  
  def parseFromLogFile(args: Array[String], GameId: String, AccountType: String, WorldId: String): AccountLogin =
    new AccountLogin(GameId, AccountType, WorldId, args(1),args(2),args(3),args(4),args(5),args(6),args(7),args(8),args(9))
  
  def canEqual(that: Any): Boolean = {
    if (that.isInstanceOf[AccountLogin]) {
      return true
    } else {
      return false
    }
  }
  
  def productArity: Int = {
    return 12
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
      case 7 => return clientIp
      case 8 => return zoneId
      case 9 => return createTime
      case 10 => return feeFlag
      case 11 => return loginWay
    }
  }
}