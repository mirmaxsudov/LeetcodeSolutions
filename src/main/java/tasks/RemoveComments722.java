package tasks;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveComments722 {
    public static void main(String[] args) {
        RemoveComments722 main = new RemoveComments722();
//        System.out.println(Arrays.toString("sdaf\\nsdsfgas".split("\\\\n")));
//        System.out.println("sdaf\\nsdsfgas".indexOf("\\n"));
//        System.out.println("sdaf/nsdsfgas".indexOf('/'));
//        System.out.println(main.removeComments(new String[]{"/*Test program */",
//                "int main()",
//                "{ ",
//                "  // variable declaration ",
//                "int a," +
//                        " b," +
//                        " c;",
//                "/* This is a test",
//                "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
        System.out.println(main.removeComments(new String[]{
                "/*/dadb/*/aec*////*//*ee*//*//b*////*badbda//*bbacdbbd*//ceb//*cdd//**//de*////*",
                "ec//*//*eebd/*/*//*////*ea/*/bc*//cbdacbeadcac/*/cee*//bcdcdde*//adabeaccdd//*",
                "ddadbede//*//*/*/ac/*/ea//*bbeb/*/ea//*a//*//*cdbeb*//ab/*/abde/*//*/d//**////*",
                "e/*/eabeea/*///*c*////*dc*//bcadcde/*/acbe//*d/*/*//ae//*dc//*cc//*//*eaebb*//",
                "eed*//cd//**///*/*//e//*bbcbbaedb*//aabb//*badb*//d/*/e*//ade//*bacbc*//ea//*a",
                "/*/bcbc//*ebdb/*/bab/*/a/*//*/d/*///*de/*///*d*//dc*///*/cd//*ccd//*a//*caacad",
                "/*/cadaacca/*/c/*/c*//bb*////*//*e//*/*//*//*//*/ebd*//abd/*/ce*//e/*/aaa//*//*",
                "cbae*//cc*///*/e/*//*/d*//bdeeee//*b*//de*//aceca*//dddd*///*///*deba*//abbdd/*/",
                "dcabe/*/a/*/bdc//*cec*//ebabc//**//*//cc//*b*//*////*abdea*///*/c*//bc//*/*/ae",
                "badcc//**//*///*/dd//*d*//*//*////*d*//eabb/*/de/*//*/*//a/*/c/*/c//*dad/*/*//",
                "dd*////*//*//*/*/*//e/*/ec*//cac*//d//*aadc/*/ae/*/ebc//*//**//*///*/bbd*//ee/*/",
                "eb/*///*cd*//dcdbaaadd//*ced/*/dcabe//*//*a/*//*///*ea*///*//*/*//b/*//*/dd/*/",
                "ba*//e*//cd//*/*/dd/*/*//dd//**//aab//**//*//*//d/*//*/*//*//*//cddecbbb//*ee*//",
                "ab//*d*//d/*/dbdcadb//*badbedb//*ac//*bd*///*//*///*/*//*/d*//d*//c/*/a//*cb//*",
                "*//e//*ad//*cdabb*///*/d/*/bcbad//*ba/*///*d/*//*/ab//*/*//*/*//*//cb//**//cac",
                "*//bedcba/*/ee/*/ecc/*/e//**//b/*/bebcbac/*//*/bcaa//*adacdcdb*///*/ecb*//e//*",
                "aeabd/*/aeead/*/ccccd//*dc*////*edc*//e/*/*//c//**//b//*aceaa/*/ccbabed*//dbba",
                "c/*/a*//aa//**//b*//beecc//*aea/*///**//c//*//*bcbb/*/e/*/*//*////*//*b/*/bdbe",
                "de/*/c*//aedb*//b*//*//*//bdad*//bece/*/ce/*/*//cacbea/*/ee/*//*/c//*ab//*/*/*//",
                "//**//cec//*ae/*/baeb//*be//*ddcbdc*//ae//*dc*//*//cbb*//cadabe*//cca//*/*/c*//",
                "//*a*//d/*/c/*/da*//ac*////**//cbb*//eccdba/*/cdec//*eb/*/ebec//*aac/*/cdcd//*",
                "*//cd*//dde//**//a/*/ea//*//*eb/*/c//*/*/babac/*/b/*/caede*///*/eabcdd*//*///*/",
                "//*d/*/*//aad//**//bcad/*///*a/*/d//*//*cebdcbedcdadebdab/*/b*//bbcabcddbab*//",
                "*///*//*/*//*//cccb/*/*//bee/*/ace*//da//*bdb//*db*//ccdab*////*/*/*//adb//*da",
                "//*aeb*//badc*//daaa*//e/*/*//aaead*//eb//*/*///*//*ae//**//c//*/*/abbdccccbe//*",
                "/*/b//*//*e//*b*//d/*/aea*//*//ae/*/c//*c*////*bdeb*//bb*//cbc/*//*/cbebabcccb",
                "e/*/daeaebc*//edceacc/*///**//e/*/ec/*/a*//bcab*///*/bbdc/*/abcdbe//**//da//*c",
                "ca//*c//*ba//*decbc*//cccdda/*/*//bcaead/*/*///*///*d/*/dda*//acdd/*///**//c//*",
                "ec//*/*/a//*bcb//*c/*/d//*e//*//*ce/*///*aeb//*b*//eb/*/edeeec//**//bdddc/*/c//*",
                "ebdce//*dedaaeda/*/*//aaea//*//*//*//**//d//*//*/*/*///*/c/*/dcadec//*/*/e*//a",
                "dadc//*/*/deed/*/*//*///*///*/*/e*//eeb/*//*/c//*dc*///*/dc/*/b//*d*////*/*/c//*",
                "/*/caddc//*//*b*//*//d/*/eadddaabebeedd//*b*//ebc/*/ec//*e/*/b*///*/abee//*/*/",
                "cb/*/d/*/eadebcaebded*//eaedc/*/e*////*a*//d//*aa*//ecedd//*abb*//dc//*//*ccbe",
                "ee//*bebbbce//*aaed//*//*/*//*///*da//*a//*//*//*//*beb*////*dbdb/*//*//*///*b",
                "eb/*/*///*/*//ce/*//*/bcdbdeee//**////*e//**//c*//eab*///*//*//*/da/*/ca/*/e//*",
                "dd//*/*//*//*/eab*///*/cddb//*//*//*bb//*//**///*/eadbbdcccdeb/*/cdecdadb/*/ca",
                "//*ccaa//*/*/ca/*/a/*/a/*/a*//*//c*//d//*//*d//*bb/*/*//a*//cb//**//bd*//aa*//",
                "cbccc//*ce/*/bb/*/aa*//eca//*b*///*//*///*dde*//*//c/*/a/*/cdac/*//*/*//eb//*b",
                "//*bceedbeb*//eaedccc//*dc/*/abeed/*/ede*///*/ebaa*////*a//*//*eb*//b*//b//*/*/",
                "//*d//*//*bbbd/*/ab*//ae*//*//e/*/ecea*//ceda*////*ccd/*/e//*ebc*//a/*//*/cea*//",
                "da*//*//e/*//*/*//b*//dbebcac//*db//*a//*a//*b//*ad/*/*///*///*dcae//*//*ebebc",
                "d*//ab/*/bac/*/*//cc/*///**//e/*/de//*/*/eaeee/*/*//bacd/*/b//*b*////**////*/*/",
                "b*///*//*/bb//*cca//*bcabc//*//*a*//ea/*/e*//c//*ba/*/bce/*//*/bad*//da/*/dc/*/",
                "da/*//*/c*//*//a*//e*//d/*///*a//*//*bc//**//bbd*///*/*//*//ede/*/b/*/ab//*/*/",
                "de//*c/*/bdc*//c/*/*//*//d//*cd/*/ce*//aaaca*///*/ccd/*/a//*b/*/beaa/*//*/dbdc",
                "e//*ad/*/dbc*//dbeae*//d//**//*////*a//**//*////*a*//*//*//cecececacdbc/*/a/*/",
                "/*//*/b/*/ed*///*/bb/*/eda*//ce*//c/*///*/*/cdcad//*d//*b*//ee//**//e/*/aeecbd",
                "dbbbe//**////**//c//*/*/aaccbab/*/*//abc/*/e/*///*a*//edc/*//*/a*///*/cccbe//*",
                "ccd*//ebb//*/*///*e*//e*//*//e//**//ec//*a*////*//*//*bcb//*e/*/d/*//*/ca/*//*/",
                "*//a*///*/bea//*cba*//bbe*//ba//*ccec/*/b/*/aeadbc/*///*eeb//*eeedc/*/a//*aaeb",
                "adaabdaaea//**//ed//**//cbeab/*//*//*/e/*/edb/*/e//*//*ccbec*//e*///*/e/*//*///*",
                "eec*//adebbbbbb*//acb/*/e*////*/*/*//a/*///*acbedd//*cd//*be*//b//*e/*/db*//*//",
                "/*/dbcbd*//a/*/ede//*b*//addc//**///*/deec*///*//*/ccddae//*aac/*///*bbbeabcec",
                "//*//*//*deaa/*/ebeb*//dbbe//**//abceededcb//*//*ebe*//ce*//c*//cc*//ce*////*//*",
                "//**//c/*/ed*//e/*/db/*/bedd/*/eccebcbce/*///*ec/*/ad/*/cb//*cabcadebcee//*ba/*/",
                "*//c*//de/*/ada/*/cc//*a//*ccb*////*dabecadea*//be/*/cba/*/d/*//*/cd//*da//*e*//",
                "*///*//*/a/*/*///*/cccb//*c/*/a//*bdddebc*///*//*/eb//*//**//aee/*/*//aec/*/a//*",
                "//*b/*/ab*//e/*/c//**//aab//*aaddcb*///*/cd/*/ecac/*///*ec//*//*dd//**//b/*/c*//",
                "/*/ab//*c*////*/*//*/eaae//*/*/cb*//*//aebb*///*///*cee*//ca*//aba/*/b//*//*c*//",
                "/*/b*//ddddcab*////*/*/cb*//eba*//d*////*/*/c/*/ccd/*/ab*//cbe*//bda//*cb//**//",
                "cb*//ebedad/*/ed//**//a//*dcaeaecaa//*/*/dcacddbe//*//*/*/dcc*//a//*cacccdea//*",
                "b*//b*///*/*//*//a/*/eac/*/b/*/ab//*/*/aa*//e//**//aac//*db//**//d/*/bd*///*///*",
                "*//*////*d//*d//*d//**//*//a/*//*//*/d//*e*////*b*//b*//bd*//c//**//cdb/*/d*//",
                "aaadddd/*/b//*//*beeddb/*///*//*cc*//abe//*c*///*/abca*//d//*dbaeebcddc//*dddc",
                "bd*//b/*/bd//*bd/*/c*//dd//*e*//*//d//**//a//*cbae/*/ab*//e*//e*//dcaa/*//*/dc",
                "ad//*abcbbb*////*b//*e/*/*//bb*////*/*/*//*//ba/*//*/dacdbcda/*/bdcbb*//*///*/",
                "*////**////**////*b*//c*////*e//*cab*//dce/*/d*//ceaaaaa//**////*addd*///*/*//",
                "//*cc/*/c/*/cc*//a/*/ac/*/a//*e*//bb/*/eae//*abb/*///*//*/*/c//*//*e//*da//*b/*/",
                "*///*/ba/*/eaeaec/*/cd/*/dac//*aacc/*///*adcd//*adce//*bea/*/bea//*ba*//*//b*//",
                "e/*/a*///*/ac*//*//*////*de*//de*//a*//ece//*dc//*dabae//*/*/ebcecdda//*de*//c",
                "a*//eccb//*ebd/*//*/dc*//e/*///*//*/*/ce/*/*//b//*edbdba//*de//**//d*//ec/*/*//",
                "a/*///*eec*///*/dd*////*//*/*//*///*aa//*d*///*/c*//d/*//*//*/c*//dcc//*ec*//c",
                "d*//c/*/a/*//*/adb/*/a//**//b*///*///*cabecca/*/eec*//caeac/*/aa//*//*//*ddbbb",
                "e*//ebca/*//*/cdc/*///**//*//bdbc*//ebdd/*/aa//*eaebbd*//c*//adbbeca*////**////*",
                "cedc*///*/e//*d*///*///*//*e/*/cda/*//*///**////*e/*/c//*dac/*/a//*//**//e//*/*/",
                "*///*/*//*//dced*//b*//b//*a//*//*d*//aab/*/dacccdc//*e//*//*edcc//*//*/*///**//",
                "/*//*/*//*//ee//*eb//*cb//*ca/*///**//*///*/ed//*cccd//**////*e//*dbcdad//*c*//",
                "//*bdeadcccddc//**//ebee*////*bb*////**//cac*////*c//*bbaca*//eeb*//c/*/aae*//",
                "//*ecd//*cddc/*/cab/*/*//bb/*/c*///*/dab*//d*//cc/*///*ccde*//c//*be//*d*///*/",
                "eb//*eabac/*/e//*d*//a/*//*/ca/*///**//a//**//a/*//*/e//*bb/*/cccdbedceb/*/d*//",
                "*//aa//*eac//**//ea//*ee//*eb/*///*e*//*//beece//*/*///*e/*///*//*//*//*e/*/bd",
                "//*/*/ae*//a*//a*//cdc*//bcc//*/*/c/*/b*//cdae//*dd*//bcbdeba*//b//**//a//*cbb",
                "b*//d//*ace/*/a//*/*/*////*//*//**//*///*/de*//a//**///*///*d*////*//*cd//**//",
                "*//bd//*//*d/*/*//e//*/*/*//*//c/*/c//*ca*//*//adaa/*/dc*//ddda//*c//*edccc/*/",
                "ba*//a//*e//*ccda*//b//*c/*//*/dc/*/eaedb/*/adbed*//bda*////*d//*a*//*//*//cb//*",
                "da*//dc/*///*b/*/cb/*/daa*//adddbd/*/be/*/b/*/b/*/c//*c*//ee//**//*//be//**//*//",
                "eccd/*/cb//*/*/ab//*ba//*/*/bc/*/ebdec//*baeadb//*//*c*//bacc//*d/*/*//b*///*/",
                "*////*ce//*a*////*bc//*/*//*/b//*/*/*//b//*//*eb/*/a*//*//dede/*/aebebc//*ba//*",
                "/*/d//*//*d//*/*/cbcedae/*/b//*/*//*/*//eae/*/a*///*///*ca//*ab//*e/*/eebea/*/",
                "a//*a*//ee//*/*/dd/*/ebe//*eaacda/*/*//c/*///*cd*///*/aa//**//aaecba/*/b//*bbe",
                "//*d//*//*ccaa/*/c//*be//**///*/e*//de/*/cce//*//*//*abbdd/*///*cceebc//*//*dd",
                "aa//*d//*//*ebc/*/ba//*bd//*/*///*//**//*////*dca/*//*/eeee/*/*////*a/*/c*//b*//",
                "*//ca*///*/*//deb//*adb*//d//*dcbbeda*//bd/*/ad//*cdd/*/ee//*//*ecea//*/*/a//*",
                "cadbbd/*/de/*///*//*//*//*//*//*bc*////*db*//bebdb//*/*/b//**////*/*/bc//*a*//",
                "d//*bc*//eda*//aaac/*///*/*/db//*dca//*edd/*/a/*/ccad*//c//*aded/*/ee/*/eead/*/",
                "*//bdaeda//*//**///*/b*//ddccbad*//ee*//ddcbcd/*/ab//*ec//*dd//*//*//*aaeddbac",
                "c//*/*/decadeed*//a*//ca//*/*/e*//bd*///*/db*////*a/*/cabdaddbeadbdaaacb*//b//*",
                "d/*/aee*//d/*/*///*/de*//de//*ab*///*/ccb/*/adbab*//c//*/*/e*//eee*//e/*//*///*",
                "d/*/*//c//**//cd/*///*d/*/b/*/bba*//dc//**///*/baca*//ddbc*//deeaead//*bd*//dd",
                "dbbdedece//*dceaa//*aeb/*/bdead//*ccbeb*////**//b//*d*//aecad//*a*////**//abeb"}));
//        System.out.println(main.removeComments(new String[]{"e/*/eabeea/*///*c*////*dc*//bcadcde/*/acbe//*d/*/*//ae//*dc//*cc//*//*eaebb*//"}));
    }

    public List<String> removeComments(String[] source) {
        StringBuilder sb = new StringBuilder();

        for (String s : source)
            sb.append(s).append("\\n");

        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < sb.length() - 2; i++) {
            // Checking single
            if (sb.charAt(i) == '/' && sb.charAt(i + 1) == '/') {
                int indexOfBreakSymbol = sb.indexOf("\\n", i + 1);

                if (indexOfBreakSymbol == -1) {
                    pairs.add(new Pair(i, sb.length()));
                    break;
                }

                pairs.add(new Pair(i, indexOfBreakSymbol));
                i = indexOfBreakSymbol + 2;
                continue;
            }

            // Checking block
            if (sb.charAt(i) == '/' && sb.charAt(i + 1) == '*' && sb.charAt(i + 2) == '/') {
                i += 3;
                continue;
            }

            if (sb.charAt(i) == '/' && sb.charAt(i + 1) == '*') {
                int indexOfEndOfBlockComment = sb.indexOf("*/", i + 2);

                if (indexOfEndOfBlockComment == -1)
                    continue;

                pairs.add(new Pair(i, indexOfEndOfBlockComment + 2));
                i = indexOfEndOfBlockComment + 2;
            }
        }

        System.out.println(pairs);

        for (int i = pairs.size() - 1; i >= 0; i--) {
            Pair pair = pairs.get(i);
            sb.delete(pair.startIndex, pair.endIndex);
        }

        String[] values = sb.toString().split("\\\\n");
        List<String> res = new ArrayList<>();

        for (String line : values) {
            if (line.isEmpty())
                continue;
            res.add(line);
        }

        return res;
    }

    @ToString
    class Pair {
        int startIndex;
        int endIndex;

        public Pair(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }
}