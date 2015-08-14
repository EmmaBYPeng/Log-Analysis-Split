package com.emma.Split


class LogLineSplit(var keyName: String, var lineValues: Array[String], var dtEventTime: String, var fileValue: String) {
  def this() = this(null, null, null, null)
  def this(keyName: String, lineValues: Array[String]) = this(keyName, lineValues, null, null)
  def this(dtEventTime: String, fileValue: String) = this(null, null, dtEventTime, fileValue)
  
  def parseLog(logLine: String): LogLineSplit = {
    val splitIndex = logLine.split("\\|", 50);
    
    if (splitIndex.length > 2) {
        return new LogLineSplit(splitIndex(0), splitIndex)
    } else {
        return new LogLineSplit("null", logLine)
    }
  }
}