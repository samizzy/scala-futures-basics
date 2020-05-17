package com.samizzy.scala.basic.futures.methods

import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.Random

object Main {

  def main(args: Array[String]): Unit = {
    val future = Future(getString()).map(sanitize).map(strip).map(stringToInt).zip(getNum()).map(tuple=> tuple._1 + tuple._2).map(println(_))
    Await.result(future, Duration.Inf)
  }

  def getNum(): Future[Int] = Future(Random.nextInt(201))

  def getString(): String = " 123 hey there"

  def sanitize(alphaNumeric: String): String = alphaNumeric.replaceAll("[a-zA-Z]", "")

  def strip(numString: String): String = numString.trim

  def stringToInt(numString: String): Int = numString.toInt

}
