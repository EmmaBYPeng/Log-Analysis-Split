package com.emma.SQLModelFactory

/**
 * @author user
 */
abstract class Base() extends Product {
  def parseFromLogFile(args: Array[String], GameId: String, AccountType: String, WorldId: String): Base
}