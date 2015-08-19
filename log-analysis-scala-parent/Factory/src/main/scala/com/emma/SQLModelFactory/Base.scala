package com.emma.SQLModelFactory

import org.apache.spark.sql.types._

abstract class Base {
  def parseFromLogFile: StructType
}