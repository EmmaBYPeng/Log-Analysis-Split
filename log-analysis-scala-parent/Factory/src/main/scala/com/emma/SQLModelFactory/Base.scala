package com.emma.SQLModelFactory

/**
 * @author user
 */
abstract class Base() {
  def parseFromLogFile(args: Array[String], GameId: String, AccountType: String, WorldId: String): Base
}