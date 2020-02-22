import xyz.lhtsky.atcrowdfunding.CrowdFundingUtils;

public class PswordTest {
    public static void main(String[] args) {
        CrowdFundingUtils crowdFundingUtils = new CrowdFundingUtils();
        String psword = CrowdFundingUtils.md5("111111");
        System.out.println(psword);
    }
}
