package com.samizzy.scala.basic

import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object Main {

  def main(args: Array[String]): Unit = {
    val numString = "123"
    val future = Future{
       print(stringToInt(numString))
    }
    Await.result(future, Duration.Inf)
  }

  def stringToInt(numString: String):Int = numString.toInt
}
