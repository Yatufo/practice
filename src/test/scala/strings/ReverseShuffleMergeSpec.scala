package strings

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._

class ReverseShuffleMergeSpec extends FlatSpec with Matchers {


  val testCases = Table(("input", "result"),
    ("abab", "ab"),
    ("ababcc", "cab"),
    ("ccabab", "abc"),
    ("cababc", "abc"),
    ("abcabc", "acb"),
    ("zabcabcz", "acbz"),
    ("cbaaaacb", "aabc"),
    ("cbaaaacbcbcb", "bcaabc"),
    ("czbaaaacbczbcb", "bcaabzc"),
    ("fwfcrwgpfflojzfiljoqluudqxrymtegsydlyvvgmfgpwkqxixelvpnlvlrxlzxyyuwmvlmnnnfvvzloypchaaqxinfvraefxrwdtlaydcljlfxkmaznojjtjaesunggyjrkkfruyjlnqjksttnegzaenrhbefrybuzobtpglngfkrckbxognhzzqwaimpqoepkcjralekbrtgdziltaznrazwoljjgrjtfrmpwutzltlfyxcmrsvjkddhnkytdvbhydfxnsoyrnrmtahvhkdfogdeghjbtlgmckossrgsaoxijvpjickcunwjgkldcnprtkrfvytlyibsngvlbtkheeokwbalqmjksmjscqkhplkghgehgbjzzynmrppfonuvlpjlzeeqjztcexvcbecdstrggoemgpmsmmlroyglzdmunrfjtmqbkrrfqewpafhfmqhzhokzyjigiwkgkrkrhtqqvpgetwtzflcmxnsljuxcvivjsmjzyjptrofjfxocidxzefznuxnhzvjcgxpnymvkicnqqfchotgavqvwmivulgniatmeoqzymvsfjcqhcondbxqsukpulvuisjvzozedtepydvkoumpyvylzkqjvozhzrhkjfgkggwxjzesxtectvfvpkmfxddhjstomgfjqdyooxezsinfxwrknvtczgwwukwagjvdwiuwmbjigxnbrdyzepgeqfaezzekqvqdkkyiwpdfrjvxzxbltjrmulfceffmuzpzftodalvjejycdyzvgtggbaeedfvsstqomwmmdfsbxocfgqhkxjkqmradotmneufmbhgaklsrxkdkjlysgivqegsqtrrzpwrptelykgeatacslhqotootuhxloutefrksqwuiyvclfcmjkocjxgtqjshiyryccgesfgpjtxjohevathpvdmtppcbsnmsfezkbulprtphgcmqywrlefmbrebemjzfzhiqcolvhdduukstgrlo", "aaaaaaaaaccddeikusbccfseagluimqvagocfqqcikvcjvhnuezxdcoxffortjyzjmsjvivcxujlsnxcfztwtegpvqqtgkwgijyzkohzhqmfhapweqbqmtfnumdzgolmmsmpgmeoggrtsdcebcvxectzjqeezjplvunofppmnyzzbgheghgklphkqcsjmsjmqabwkoeehktblvgnsbiltyvfrktrpcdkgjwnuckcijpvixosgrssokcmgltbhedgodkhvhtmrnryosnxfdyhbvdtykhddkjvsrmxyfltlztuwpmrftjrgjjlowzrnztizdgtrbkelrjkpeoqpmiwqzzhgoxbkrkfggptbozuyrfehrezenttskjqjyurfkkrjyggnusejtjjonzmkxfjldyltdwrxfervfixqhpyolzvvfnnnmlvmwuyyxzlxrlvlnpvlexixqkwpfmgvvyldysetmyrxqduulqojlfzjolffpgwrfwf"),
    ("eggegg", "egg"))

  "Solution" should "should find the right result" in {
    forAll(testCases) { (input:String, result:String ) => {
      ReverseShuffleMerge.solve(input) shouldBe result
    }

    }
  }

}
