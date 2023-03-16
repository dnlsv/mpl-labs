import org.scalatest.FunSuite

class Test extends FunSuite {

  test("Char in string, charInStrTailRec") {
    assert(Main.charInStrTailRec("Hello World", 'o') === 2)
  }

  test("Char in string, charInStrFor") {
    assert(Main.charInStrTailRec("Hello ladies and gentlemen", 'a') === 2)
  }

  test("The most digits in string, digitsInStrTailRec") {
    assert(Main.digitsInStrTailRec("1112222223333333333311") === 11)
  }

  test("The most digits in string, digitsInStrFor") {
    assert(Main.digitsInStrFor("111222222222333") === 9)
  }
}
