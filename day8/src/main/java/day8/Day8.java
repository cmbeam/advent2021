package day8;

import java.util.*;

public class Day8 {
    final static String input = "bceadfg ebcdaf gdaecf fgcaeb fdbea fcdea cbda begdf afb ba | acfbeg cbfgea gebacf ab\n" +
            "bg dfcba agedcb dfgab agb cafedgb gfdea ceafdg bfgade gbef | befg gafde dafbg cfbadeg\n" +
            "fg befdc afecdbg gbf gfcdab cfge cbdfeg efbdg baegd deafcb | bgf edfbac ebgdf fgb\n" +
            "agbec dbfac gfadeb dgaefcb febcda dcgf bcagd gda fgacdb gd | fgcd fadbce agd dag\n" +
            "bgfad cdfea cfedag bafedc efbda befcadg egbcdf bed be ecab | ecba bed edfab afecgd\n" +
            "dcebaf gf agbcfe agdbcf bfg eafbc gfea gbdce ceafgdb cegfb | faecbd ebcdaf fbg gf\n" +
            "cbgfad fgcae agfbd egd bdafecg ebad bgdcef ed egfda dgfaeb | eadb cagbfd ecgfa agcedfb\n" +
            "afb efadc ba cafbdge daeb cbgfad fbegc cgaedf ceafb fbcdea | fdcbea dfcbage daecf ba\n" +
            "cfbg efc ecdbf eafgbdc fc gfdeb fagdeb cbead ecgafd bdfecg | dbgef fdbceg adbce fegdba\n" +
            "faegdb daegcfb cbgeaf cgbfe fdg bcfda gd gced gcefdb dcbgf | fgd dg fbcad gcfeb\n" +
            "fcagbd ega aecbf eafgb fgcaedb dgeafb fgdab ge gadbec gfde | ge fdge ega egabf\n" +
            "bgcaf dfgea fdbga cafdbeg db adbc cgdabf edfgcb aecbfg bfd | cgdbaf gbadf gbcfae gcabf\n" +
            "bcgea baegdc efagb feacgdb edafb gefcdb fg gef cgfa febagc | gafeb efbga agcf gecbdaf\n" +
            "egbf fdeba fdg ecdafb ebgdfa cegad dbafceg gf agdfe bgacdf | dbceaf agdfe eadbf cfebgad\n" +
            "ged aebg dabegc gdeafc gacbd edfagbc agcdbf eg efbcd gbced | gdebc eabg geab gcadbe\n" +
            "acfe acbgfde gfbed bdcgaf gaebfc ebgaf cebadg cgfab eab ea | fgacb edagbc bgeaf ea\n" +
            "adbgc acbe aedcgb fgadce cb gcb dgcea ecdgfb dbefacg adbgf | fgbcde adcgefb bc eagcdfb\n" +
            "caeg fcbagd ce cgebda afebcdg dfbae acgbd begfdc ceb debca | febda ce ce cdgbfe\n" +
            "bad db agdfec fbacdg gedcbfa bcfd dgafb fdcga adgebc agbef | bad dfegcab bd cadfbge\n" +
            "cea efdbagc cdaf ca ebdfgc dbeac egbafc aebdg adcebf cfebd | dbegfc ceadb ac bfegadc\n" +
            "gfd fecbgda faebd gd fegdab adge ecfbg baefdc cbfadg gdfeb | cebfda gfd dg agdefcb\n" +
            "cade cbagf cfe cgdeabf ce dgfeab dabfe feacdb ebacf cdfebg | caed dcfageb gafcb efc\n" +
            "efbgda bdgc aebfc dc dfecga afdcb acd eadfgcb fabgdc dbafg | gdcb cdefag fdaegcb fegcad\n" +
            "efacbdg afeg adfcg bagcfd dcafe ebcda gdcbef fce ef dfcgae | afcgdb adfec efc aecbd\n" +
            "afbge adgbfc gef fbagd ecgdfb caedfbg eadg ebdafg ebcaf ge | edga afbge gdefcba dfbag\n" +
            "aegdc efbad cfbdea dcafe cfe cf gebfac fbdgae fcbd adcfgbe | ebadf dfcb dgaec abdef\n" +
            "acbfg adefcbg edagfb gadef dfb eabd bdfgce adgfec dgfba db | db fdegac aedcgf gfcade\n" +
            "aecgdb fdeba gfbc degafcb adbcg cf afdbgc cdfba fgdace cfd | gcbf fgcb cf fgecabd\n" +
            "cfaged badg bcfaeg dfg edbfg dabgfe dcfagbe dg debfc efbga | dfg agdb bfced cbdefag\n" +
            "ac dabeg cdfbe cbfa gedafc acd fadgecb bedcgf caedbf becda | egdcbf adc ac fgbaecd\n" +
            "fagbd ed cfegb gbcfde fdegb fbaegc fbcaedg efdbac dgec dfe | gafcbe bcefga edf gbdef\n" +
            "dfecg gb fcgbaed gcb dgbf cfgdbe dcbge cebad acegdf gafebc | cfebag eacdfg cgb fdgb\n" +
            "abegdfc fdbeag fdac gdefc cfgdeb gceafd ad cdaeg gad aecbg | dbefga da acdf gfbdec\n" +
            "cgaf gedab egafdc gcfbed cfdbae cge fabegcd gc caefd cgead | eacfdg fgdaebc ceg ecg\n" +
            "faceb fbaceg fgcdbe fdcga fbdca bfd db eafdcb aegfbcd dbae | cfadb cbaef gcadf ecbfa\n" +
            "adeb cbgdae cde fcegb ed fdgbac adgefbc bcegd fgcdae gadbc | gdfbca dce dgbac bacdgfe\n" +
            "geadc fegda cabe bcfgad gbecad ced ec fecgdab efcgbd adgcb | gdfae dbfcega edc ecd\n" +
            "acg eacdg ca dcegb fgdea abcdefg bcad adgbec gebdcf acgbfe | cga dgbec gac cfbeag\n" +
            "bdgfc dcg febcg gcedab dc bafdg deafbg fbdgac dgabefc cdfa | cd dc fbdcg fbgce\n" +
            "efdbag adgec fcgbda bcd dbecgfa ecfb fbdge bc dfegcb dcgeb | gdcfbe dbcaefg fdgeb bgefd\n" +
            "adebgcf dfbgac bdfeac dcega egdcfb febdc bad acbed ab beaf | befcgd afeb acedb dbefc\n" +
            "bead cdgfe bdacfg eb abfcd badgfec abcdfe feagbc cbe ebcfd | dcfbe bec baecfg eb\n" +
            "dcgafe dafcbg cfage df gedcb cfedg dfg fead bfeacg gafcbde | egdfca fgdec edfa aedf\n" +
            "ac cfbgaed adcbg bgcde eadc abdgf cebgfa becdga dgebcf bac | adcbg dbacgef egdbfc ca\n" +
            "ac acd cdage acfbgde dbacge degfcb gdefa bgca cbedg fcdeab | decga ac cda efbcdag\n" +
            "facbg gdaceb cg gecf agefb acdgfeb cafegb cag dcafb adbfge | agbedf fgec gc adcbf\n" +
            "bfdc cbged egcbdf egfdb bgf bdagce fgead bf ecgbaf cgebfad | fb bgf dbecgf bfdc\n" +
            "fbeacgd dfabcg ebdgc bafdg cfdabe ac abc acfg dgbac fbgade | bacgd gbdec adbfeg cdagb\n" +
            "dbfga dcf debgcaf egbdaf gdfac cf efabdc fbdgac gbcf cgeda | fc cgbf cf gfeabd\n" +
            "fdebac gcdb efabg aegbdc bcega gac dfgebca cadeb gc egcfad | gc acg edcba ecabd\n" +
            "cgfeb gcebfd fge gedb bgcfa fcdgea acdebf ge bcgafde defcb | gfdceb bcafed cbfgead fdecga\n" +
            "gdcfba cadge ac aefc decfga dgbafe fgeda dfceabg cebdg cag | acbfdge edgabf dagec gac\n" +
            "befacdg bdeg acefdg gdebac bcadgf ecadg fbeac cdb cdbea db | bd db gfdace bd\n" +
            "gcabf edfb dbacf acefgd daceb ebacfgd fd feabcd gbdcea fda | dacgfe gcebda cgaefd fgcbdae\n" +
            "bcadg fbcgd caeg ecbda gaebcd fbaced gedafb ag gad bgfcaed | aebfcd bfceda dga ga\n" +
            "egfad efab gdcba afcgde gfb cgdfeab gdafeb ebcgfd fadbg bf | dacbg dbafg fbg eafgd\n" +
            "efda bfdcg aecfgb becfda adb bcdfa caefb da baecgd dfcageb | cfabe dab bgfcdae gfedacb\n" +
            "bead dgabc begcfd cgfbea cabeg edbgca dacfg dfgabce dbc bd | fgdebc bdc egabcd adbe\n" +
            "be gaecdfb fcgdb dbfec dbfcag ebc cfade dcbefg gefcab egbd | fgabdc aegfcb degcbf bcdgfe\n" +
            "acedf agdb efdbag bdgfec afdcgbe dbfae cfagbe fba ab egfbd | acefgbd bedfa gdebaf ab\n" +
            "dab efcbd edafbcg cbfeda abgedf fbca bfcedg ab cabde dgcea | ebcgfd bagdfce dgcafeb ecbdf\n" +
            "fgdeac gda gabedfc gcefa da adec gedbf abdgcf egdfa cagbfe | gbcfae eacbgfd eacfbg ad\n" +
            "bdacegf ef begcda ecgf cefda fea bcdaf dfgeac gbfeda cdaeg | ef ecfg fcge dgcea\n" +
            "fabdge cgfad defga fc bdecgfa cbgad gcfe fdacbe fac cgeafd | cfa fegadb eadfbc gcef\n" +
            "dbcefa agbced acfbg efbagd dc bdacg ebdcagf decg gdaeb acd | cd badfce dc dabfec\n" +
            "adgb cgdaf ga eacgdfb cgdbf agfbcd gaf gcfdeb fbegac eafcd | abdcgf cgedfb bdcfg gbcfd\n" +
            "fgcadb dag da cbafg abgedc afcd gebfd dfagb efcbga adgbfce | cbfdage acdf afdc fcad\n" +
            "badce efbcda bcd dbfecg ebdaf bfcaedg afcd baecg cd dbfaeg | cd ecdbfa aebdc gbdfec\n" +
            "bfgdac cafbeg abgecd cgebdfa bgacf dc gfcd dcafb cbd dfbea | dc fdgc fabgc dc\n" +
            "bafgd egaf eadfgb dfa bcgefda cfdgb gaebd fa degacb dcabfe | agfedbc badecg cebadg adf\n" +
            "bc egdca cbdfae fcbgea aegcb fcgb egfbda cba fbega bacdgfe | cb egdbcfa abgce cb\n" +
            "bagef fgb cagfbe bg acegf adfgbc fedabgc dfeagc efbda gecb | bgf aebcfdg bg fgb\n" +
            "fdabeg egbfc fcgbda cgda gfbdc cedabf cdf abdgf bdcgefa dc | fbgdeca dbcafg fbgce cfegb\n" +
            "bacedf bdgca fdgbaec dbc dc bgacf bfdgca dfcg becagf gadeb | caedfb bgacf cbgafe acfebg\n" +
            "dfcebag def edbc aedgbf dacef bdcaf fcage ed cbfgda becfda | bdec edafbg caedfb dcafb\n" +
            "cfabg ebfagc aecdgb edgbcaf cgf fg fdabc ebgfdc gcbae fega | adbegc gcf bgeac bfacg\n" +
            "eadf beagdc dag bfdcg gafbec feadbg bgdaf gbaef bdgfcea ad | egfbcad ecadgb bgdaf acgfdbe\n" +
            "dabgce ecfdg fg fega dcefb bcedfga edgca fcbdag cgdeaf fcg | gaef cgfdaeb agfedc aegdc\n" +
            "gebd de dfega efbacd ead gdcfbae afcgd fabecg ebfag gfadbe | cgeabf bfcega cfabeg bgceaf\n" +
            "cfd gcedb egdbfc egdfca df ecgdbaf bcaef dacgeb fcedb bfgd | gdbec fd fd gbecd\n" +
            "agdec dbfcea gfcead gfbaecd cab gdba cgfeb ceabg eacbgd ab | eacdgf bfecad gedcfa abdg\n" +
            "cbgae baedcg dbcg bdefacg cb acb fadbce eacfg aebfdg egdab | aegbc dgcb cbdg ebfagd\n" +
            "fgbcd dfa gdab fecga afedbc dcfga fgacdb da bfcedg begcadf | facedb aedgbcf gdbcfa cdgfbe\n" +
            "aedfb fda bagfdc ad efbga bdfce gebdfc egfcbad ecbfad ecad | dgebcf dcae edca bdfgca\n" +
            "acfb cebgf daebgf gacfe fecdag gbf bcdeg gbadcfe bf gcbfea | aecgfd badfge gfcaed gcedb\n" +
            "abdg cfdeb ceafgd ebgdaf edg fcagbe dg bdegcfa gedfb aefgb | egbadcf bedgf abefcdg gcbaef\n" +
            "cgaefbd dfa cdag da fdecg dcgfae caefd ceafb gdefba cdbfge | dgcbef ad gefdc edbcgaf\n" +
            "bc dfcage geafb cgefdb bcefad fcaeb cfb agecbdf dcab acfed | ecfda bcda bdac cgdabfe\n" +
            "adbef bdcae dgeabf gfad gaedbfc ecbfdg fcebga af abf dfbeg | afebgc dfabe fba efbcga\n" +
            "agbc fcbea cfged bdfgaec cafbeg gacef ag dfbage aefdbc agf | cbga ga fegdc ag\n" +
            "gadbe acfg cgaed fcgbde edcfbag dca degcf ac dcafeg cdfabe | fgecad cgaf cgdefb ebadg\n" +
            "dcbegf gdaeb dcgfea dcbag fcba afgcd gbdcefa cb bcafdg dbc | cdbfeg bdc cbfa dcaebgf\n" +
            "cagbe fcdbg cfdgabe fdagec ecd agfbcd ebdf bfgdec de gbecd | bfcegd eagbc defb gcfbad\n" +
            "fbgdeca cged bgd bcdef cfgabd gd eagbf fdcbea gfbde ecbdfg | gd gdb cdeg dcfaeb\n" +
            "df bgacfd fagbc facbged bgfad fdecab dcgf bgdea afgceb adf | bdafgc gbfac acebgdf gafbec\n" +
            "adc abecfdg acbgfd ebafgd cfged ca acgdf adfbg dbcage bfac | bfgacd ca dafbg cebdga\n" +
            "debfa fgdbec edgcaf cbdfe dfa af bafdceg afcebd edabg bafc | edafb fa cefdab fa\n" +
            "bacfg gadecfb fda cgfeba cebda bfdg df fadcb fedcga acgfbd | abcfeg cdbaf daebc fecdgba\n" +
            "fdgec fegbc cb degacf cbg bgdcea fabge dbeafgc edbgfc bfdc | fdcb gbacfed cb bgc\n" +
            "afcb ab bad adcgf bgcfaed gabcd dgfacb faegcd gbafed gbedc | acbdg cbaf bcfa acgdb\n" +
            "fdebag ecdfga fagdb dcfaegb fb egfad fbcged efab cdgba dfb | efab cfbedg dbgafce aebf\n" +
            "edbag bgaecd fcagd bedafgc fagdb dbef badfeg bf gfacbe gbf | fdbe bf caefgb bdfage\n" +
            "adgfe dfec fd degacfb agedb afd cfdabg cfaeg eafcgb cafgde | afbgcd adf eabgfc cfde\n" +
            "dba cfgdbea da gbcae gaebfd aefd agdcbf defgb bedcgf agbde | egbda fedbgac edaf ad\n" +
            "ae fbgecda gabdc bagde defbg ebca fbdgac ecgbda cfadeg aeg | agdbe bdeag ecba age\n" +
            "dg gdc agcfe ebcgdf dfabcg fbcda fdgca gfeabcd bfaecd dbga | fbdegc dg fcbdga gd\n" +
            "fdebga bdgfa dabecfg bcedg cda ac acgbd abdgfc eacfgd acbf | cda cfgdba fedcag ca\n" +
            "dbceag fcgab efgab agc cdbgfe bgcfd ca bfacgd bdcafeg fadc | ca fcbgd adcf abcfg\n" +
            "fdacbg bcde acfdge acdfb abcef gabfe befagdc fce ec aedfbc | adcfeg agdcbef acdfge ecadgbf\n" +
            "aegf bgcdeaf gbfcad dcaefg gdefc bfced fg ecabgd gcf gadec | cgaed cgf ecgfd cfg\n" +
            "becdg gbfca cebgfa faebcd ae fcadgb fgeadcb ecgab gfea aeb | gebca cagbe ecfgabd agef\n" +
            "dbc agcd eagbdcf bfecda caegfb gcabf dfbcg dc bdgcaf gbdef | cd bdc fbcgae bcgfea\n" +
            "dbcaeg cfag gfedcab bcefa beagf egfacb defbg ag gba dfacbe | faecbgd acfedb eacdfb baefg\n" +
            "ebcgafd badce abfeg efgabc adfeb adf begafd dfeg gfdcab fd | ecbda aebfcg dcfagb ebcad\n" +
            "cdgbef ecgdab fgacdeb cdbfg eadfbg dcg cabgf cd fecd bgdfe | abdecg edgbfa fdbge gadbef\n" +
            "bfagd dfge acgbe bde dacbfg ebgda cefdbga fbcade de dafbeg | dafebc gbdeafc dfeg fedg\n" +
            "gadefbc gdfabc db dgbaf acbd agdfe bcgfa decbfg cfgeba dbf | gdbecfa bcda agfbec adgef\n" +
            "deg fgcd gd ecabg eagcd edcfa fgcdbea efbdca edacfg gdbfea | edagcf eacbdf daceg gde\n" +
            "cdfegb gcae dfabge begcf ae cabfeg abecf bea dcafb adfcgbe | ae cebgdfa gcbafe ae\n" +
            "acgfb da dga bcgad dcfa ebdafg bdcefag debgc bfdgca bgfeac | dga dag da abgfc\n" +
            "dgace gfc gfab gdcfa dbfegc bafcgd gdefbac fcadb bdfcae gf | gcf gecad fgacbde bdagfc\n" +
            "gabfce aegfd ac cgafe abcg eca debcfa fegcbda cgdfbe gecfb | ca aec ca gaefdcb\n" +
            "bcefa efdbc ed fde gdcfb dgabfec dbae adfebc ecgfab gcadfe | fed bafec baefc ebfacd\n" +
            "dagbf fb fgdeac bcdag fecbdg aefdg efab bfg gbaefd bfgcaed | efab afdbge gdbfa dcabg\n" +
            "gcdefa cdbgea gd efdab edg fegbdac fagce bgface dgcf eadgf | cdeafbg cagfde faebcgd gd\n" +
            "dfbgce edfgc deacgf fdbgeac befd acfbgd gbd gcdbe eabgc bd | dgecb egcdf eagcb fdgec\n" +
            "fdcbeg agbcd facdge aefb gedba dea fgbead dgacfeb ebdgf ea | dgeab afebgd dbgfec dae\n" +
            "dbfeag bfgca dfac abdfcg baf gceba bgdcf fa cfebgd afgbcde | afdc adfc bgdefac abf\n" +
            "fedbga cgdbef afdcgeb bdefg ae bdacg gdbea adef eba egabcf | ea dgecbaf gdabe fadbecg\n" +
            "daegcb bgc ecfdb adgfb egfc dcfgb cg efacdb cegfdb gcafedb | gadbcfe cgdbf dbgcfe gdbaf\n" +
            "dagf bcdfg aebcdf afbdecg fgdcab ebacg afb egcfbd af bgfac | afdg af fcgdb afb\n" +
            "dafbe dbfg agedf fg fabgce fga egbfad gcead ecadbf dfcgabe | cgaedfb edbgacf bcgfae bceadfg\n" +
            "cadbfeg abfde fabdc dfebag gdaecb afe daefgc gbdea efgb fe | eaf bgead gadbe befdga\n" +
            "gb cgba decbg abefdc egb bagecfd egcadb ecgfd begfad adcbe | bcga feabcd bg bg\n" +
            "dcbg bfdega dg gfceba cgeba caedf edgac ebgadc dag bceafdg | fceabg dg gdeac dg\n" +
            "ecadgb cdebgfa edabg fe efgd eagbfc bagdef dcfab fbade eaf | gbdaec efdab fae afe\n" +
            "begac fdbeag dce cdaf fdgceba fcdbea dgfecb cbeda cd dbeaf | ecfbda edcfab baecg edbagf\n" +
            "cdabef cbaef gedcafb dbfce fbgcde af fdab gfcead aef gcabe | edcafg fedbc cfdagbe cefdb\n" +
            "gadecb adecb fda fa abfc aefdc badegf fgcedab feacdb gdfec | fecdba fcba bdcea aefgdb\n" +
            "ec adgcb cdagfb abecdg fgbed aecd ecbgd ecfgdab gecfab bce | bec aecd ce adce\n" +
            "bgfdace fb fdabge faedgc cbfed dfcbea fbe gcbde fcab cfade | gbcedfa becafdg faecbgd bfcdea\n" +
            "aegd gbedacf fbgcda gebdc dcabeg gcbef gd baedc bdg cefabd | edbcfag baefcgd agbfdce gaed\n" +
            "efgcb ecbdag gdac ca gbade geabdfc bagec aebcdf ace gbaefd | eca egbcad aec cagd\n" +
            "ecabg abdgce efdbag bg cbdg cedfabg fbeca dgaec beg gafdec | gbdc aegdc baefc cgeba\n" +
            "ecfdgab fde afgd bcfeg ecdga gbdace fedabc cdefg df dgcafe | fd efdcg dfe cgfdae\n" +
            "bcdfeg gdfaec badcg db bdc gdfaebc egbac fdba cafgd dfcgba | cfadg afbd edcgaf agedcf\n" +
            "bcaeg beadg gbdaec dbe ebgcaf ed aedc dfbaecg gfdab gbefcd | bdegfc abgced gecba bagedcf\n" +
            "gdabf bfage bef bceg abgedfc cbgefa eb defbac acegdf eacgf | eb begaf becg fgecba\n" +
            "egdc dgfcb fdg fbegad bgecaf cafegbd gd fbcdeg dcabf cegbf | gd gacebf fcdab gbfcaed\n" +
            "cged dcbfae badgef gdcbefa aecgf aefcd aeg cadfeg eg gafbc | fedca degc faecd edgc\n" +
            "eadcfg ad acegf cefad eagdcfb adc ceagbf gfdabc fecdb geda | cfedbag cafegb gcfdeab ad\n" +
            "gfcdbe edbac cgbfae df cdbgfa dgecafb cfbge cefdb dcf egfd | cbfgeda df cdebf bgecf\n" +
            "facdb bfcadeg edafcb fbdcag bdgc edfcag cg eagfb gcf gcafb | fdceab gfeab dafcb gcdbaf\n" +
            "ebafc fecdbg fed fcbdea dfeab afdc gedba efagbc df gacedbf | cbfaeg fegdbac cgebfa df\n" +
            "fcd feabd cdge fdagcb fdaebcg cd egfbc fbedc dcgfeb afcgbe | dfebc fdbce dcf cefdb\n" +
            "gfaed degcfa cf caf eadcb aecbfg fbedagc cfdg afdec gbdeaf | dcfg cf afc caf\n" +
            "ebgcdf cfgeb dbcfa fgdebac gfea cea bfcaeg ae egadcb befac | efga ebcgaf cgedbf ecfab\n" +
            "efcbg afcbe afedbc fgedc bge bgac deabgf gb cabgedf fecgba | bgcaef egb gb cdabefg\n" +
            "dbeafg dg degbacf gdac becdf cebdg dgb gebcad cbeag fbcgea | egcbd cgaeb dg decgbfa\n" +
            "dcb dfcga adbfgc fdbeac acefdg bgfcd bgefd bacdfge cagb bc | adecfbg bc gabc fcgdab\n" +
            "bdf fdea df fdcegb befgcad cabef gabcfe facdb abecfd gabdc | eadgcbf fd fdea dafe\n" +
            "afgeb fdgcb gbedafc ecafbg ceafdb ad fdgab dgae fad eadgbf | afgdb gdae da ad\n" +
            "dbcfg gfed cebgf gbcae ebf cebdaf bdefcg afebgcd fe acbfdg | fe bdafegc ef bgeca\n" +
            "cebga ceg cgfbde aegdcb gc febgcad fgeab dcag ebcad cebdfa | gc gcda fgabe ecbdfa\n" +
            "gcdefa egbac defbcga da cegdba fdebg bcda fcgaeb eda dageb | gbaced begdf dae da\n" +
            "bgfd bcaeg bd ecadfb aebdfg gcaedbf dcefga geadb edb adfeg | db efdgba gfdb egdba\n" +
            "dgc defc dcagfeb gcfbd gdbef abfgc bagcde bgaefd dc egdbfc | febdg adgcbe dc agbfc\n" +
            "gbdafe fgb cebg ecbfad bcfae acfbg cfagdeb facegb gb cagdf | gfb bfceadg gb agbcf\n" +
            "edfab db acegfdb dbf fbaedg dgbe cgabef geabf dcafe abgcdf | db gdcfba bfadge fbgaed\n" +
            "eagbfc efca abefdgc dbgfce cgabd abfedg cf efgba cgafb cbf | cebgfa fc gbcad bcf\n" +
            "dfgbc fgc dbgca begdf gecadf geacbdf cdaegb fdagbc cbaf fc | cfab bdcgea cf gdcab\n" +
            "fdcbg cegfd dbafc gebf bg bfcdge gcdfae acgedb acfebdg bgd | gdfce efcdg eagdcf dbg\n" +
            "dg fcbdae bgad faecbdg agedf ecdbfg efabdg aegcf fabed egd | fgaedcb dafgbe cbedaf efdag\n" +
            "bcea gdaefb abd ecbdf fgcbed efdcab dfacb cafgd ba fdegcba | cgafd daegbf cbea ba\n" +
            "cfedbga dgce gafbe fdeag cdafbe dg gecafd dgf facbdg cdaef | dcefga fadeg bgeaf abfeg\n" +
            "cegdaf gbaec dceafb gfdb febag dafgebc fg abefd gef fbagde | gf dfegcba bdgaef efgdbca\n" +
            "fagcd aecdbf ebcadg edcbf gdbfc bg bgc dfcgeb bfeg afecbgd | dgcabe cfaedb gbc fdgbc\n" +
            "geafdb gacfed eadbg gce eagbdc begca ce bced cagfb gdaecfb | fcedag gecbad gcbfa ec\n" +
            "begcfa gaebfd fd cdgeb gafce afcd agfdce fdgec dgf gfacdbe | efgabd adfc efacg eacfgd\n" +
            "gefca de adefg eacd gbdfec ecfbag geabfcd efd dfegca bgadf | afcgbed agefcd bfdeagc dcea\n" +
            "ebadc cagedb adcfbeg eadfcb fcdbg cfea faebdg fe decbf fed | gcbfd cabedfg bcadef bedcf\n" +
            "ce cbfdg cbfge gacbef aceg cbgadfe gbefa feagbd cef dbfcae | egcbf dafegb ec cef\n" +
            "eagfd gc fgdace gcea dfacgb dgeafb fgc dbfce gdfbeac degfc | cagdfe cg aegc gc\n" +
            "bcade efgbda fgbed edcbagf cfegbd cbegd cgef gdc gc afbcdg | bdace befdg dcg cg\n" +
            "fdabce gcdebaf dceg bdgfae dag gacbf dg cbaed bcdag begcda | aegbdc gd cabedg gda\n" +
            "gf gfdbac fgecb gfc gdceab fbagce ecdbf efdgcba aefg eagbc | gbeca cefbg gcabe acedgb\n" +
            "dbcaf bcedf gdbfa cedafbg edbgfa agfecb afc bcafgd ca cagd | cafbd caf gcfadb ac\n" +
            "dbeafc dcaegb cd dcb cgdba dabecgf egadb dbagfe gbfca gced | cabgf gced dc dgce\n" +
            "bgce aebcfg agecdf bface efc febda gaebdcf ec bgcaf bacgfd | abfde ec efc cebg\n" +
            "gdeafc ce defcgb gbec fce fdbea cbdef fcdbga gbaecfd bdgcf | ce ecfgdb cfe fedcb\n" +
            "aegb fedag egf dabfeg dbcafeg defba fcbdae ge adgfc fgedcb | efg dcegfb edcafbg ge\n" +
            "debagf febgcd gfc dcfgba fbegc fc ebfgd cfed bagfedc aecbg | cfg cgf fgc gebac\n" +
            "gcfdbe bagfecd fcdbe eb fbeg bgadec cadbf gefdc dbe cafgde | deb eb egfbdac dcgaeb\n" +
            "dgfea bdefa efb eb edcb gcbafe efdcab dacfb bgcfad adcgbef | dbce ebdc dbgfca bafgec\n" +
            "becfgd eagcdb dceafb bdf cdbfa edbac efgdcba dcagf fb feba | ebfa fabe bcedaf bf\n" +
            "bdcaf cgfdeb cfeadg cgd gd dega dfabcge fcagd ecfgab fcaeg | gdc dcbfa eafcbdg gdcaf\n" +
            "cgedba edagf gb gfcdae gcfeabd dbg aedfbg gdebf edfbc abgf | dfabeg dfgea gdb fcabdge\n" +
            "agbefcd fgadb dfbage efbd gcbda adfge cbfgea fb fab dcfega | bf ebgdacf fedag fegda\n" +
            "efdbg fbdcge agdfe cabfdg ebf eb dfgcb dagcfeb ebcd cafegb | eb dfbegac bgfde fcdbg\n" +
            "ecfba egf dgbeaf dbgcfea gf egfcb egabcd cfgd gefcdb egdcb | gbfec dcfg fg fbgce";

    final static String testInput = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | " +
            "fdgacbe cefdb cefbgd gcbe\n" +
            "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | " +
            "fcgedb cgb dgebacf gc\n" +
            "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | " +
            "cg cg fdcagb cbg\n" +
            "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | " +
            "efabcd cedba gadfec cb\n" +
            "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | " +
            "gecf egdcabf bgf bfgea\n" +
            "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | " +
            "gebdcfa ecba ca fadegcb\n" +
            "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | " +
            "cefg dcbef fcge gbcadfe\n" +
            "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | " +
            "ed bcgafe cdgba cbgef\n" +
            "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | " +
            "gbdfcae bgc cg cgb\n" +
            "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | " +
            "fgae cfgab fg bagce";

    public static void main(String[] args) {


        Dictionary<String, Integer> encoding = new Hashtable<>();
        encoding.put("467889A", 0);
        encoding.put("89AAAAA", 1);//
        encoding.put("47788AA", 2);//
        encoding.put("77889AA", 3);//
        encoding.put("6789AAA", 4);//
        encoding.put("67789AA", 5);//
        encoding.put("467789A", 6);//
        encoding.put("889AAAA", 7);//
        encoding.put("4677889", 8);//
        encoding.put("677889A", 9);//

        String[] firstInputs = input.split("\n");

        List<String> secondInputs = new ArrayList<>();
        double sumOfSums = 0;
        for (String input : firstInputs
        ) {
            String[] twoSides = input.split("\\s\\|\\s");
            Set<String> distincts = new HashSet<>();
            String[] sInput = twoSides[0].split("\\s");


            int[] counts = new int[7];
            for (int i = 0; i < counts.length; i++) {
                counts[i] = 0;
            }
            for (String tinput : sInput
            ) {
              //  System.out.println(tinput);
                char tempArray[] = tinput.toCharArray();
                Arrays.sort(tempArray);
                distincts.add(new String().valueOf(tempArray));
            }
            //System.out.println();
            for (String distinct : distincts) {
               // System.out.println(distinct);
                char tempArray[] = distinct.toCharArray();
                for (char character : tempArray) {
                    if (character == 'a')
                        counts[0]++;
                    if (character == 'b')
                        counts[1]++;
                    if (character == 'c')
                        counts[2]++;
                    if (character == 'd')
                        counts[3]++;
                    if (character == 'e')
                        counts[4]++;
                    if (character == 'f')
                        counts[5]++;
                    if (character == 'g')
                        counts[6]++;
                }
            }
            for (int i = 0; i < 7; i++) {
                //System.out.print(counts[i] + " ");
            }

           // System.out.println();

            for (String distinct : distincts) {
                char tempArray[] = distinct.toCharArray();
                char coders[] = new char[7];
                for (int i = 0; i < coders.length ; i++) {
                    coders[i] = 'A';
                }
                int pos = 0;
                for (char character : tempArray) {
                    if (character == 'a') {
                        coders[pos] = String.valueOf(counts[0]).charAt(0);
                       // System.out.print(counts[0]);
                    }
                    if (character == 'b'){
                        coders[pos] = String.valueOf(counts[1]).charAt(0);
                       // System.out.print(counts[1]);
                    }
                    if (character == 'c') {
                        coders[pos] = String.valueOf(counts[2]).charAt(0);
                        //System.out.print(counts[2]);
                    }
                    if (character == 'd') {
                        coders[pos] = String.valueOf(counts[3]).charAt(0);
                       // System.out.print(counts[3]);
                    }
                    if (character == 'e') {
                        coders[pos] = String.valueOf(counts[4]).charAt(0);
                        //System.out.print(counts[4]);
                    }
                    if (character == 'f') {
                        coders[pos] = String.valueOf(counts[5]).charAt(0);;
                        //System.out.print(counts[5]);
                    }
                    if (character == 'g') {
                        coders[pos] = String.valueOf(counts[6]).charAt(0);;
                       // System.out.print(counts[6]);
                    }
                    pos++;
                }

                Arrays.sort(coders);


               // System.out.println();
                //String text = String.copyValueOf(coders);
                //System.out.println(text);
                for (char coder:coders
                ) {
                    //System.out.print(coder);
                }
                //System.out.println();
            }
            String[] answerInput = twoSides[1].split("\\s");
            for (String answer:answerInput
            ) {
                //System.out.println(answer);
            }
            double sum = 0;
            int powert = 3;
            for (String distinct : answerInput) {
                char tempArray[] = distinct.toCharArray();
                char coders[] = new char[7];
                for (int i = 0; i < coders.length ; i++) {
                    coders[i] = 'A';
                }
                int pos = 0;

                for (char character : tempArray) {
                    if (character == 'a') {
                        coders[pos] = String.valueOf(counts[0]).charAt(0);
                       // System.out.print(counts[0]);
                    }
                    if (character == 'b'){
                        coders[pos] = String.valueOf(counts[1]).charAt(0);
                        //System.out.print(counts[1]);
                    }
                    if (character == 'c') {
                        coders[pos] = String.valueOf(counts[2]).charAt(0);
                        //System.out.print(counts[2]);
                    }
                    if (character == 'd') {
                        coders[pos] = String.valueOf(counts[3]).charAt(0);
                        //System.out.print(counts[3]);
                    }
                    if (character == 'e') {
                        coders[pos] = String.valueOf(counts[4]).charAt(0);
                        //System.out.print(counts[4]);
                    }
                    if (character == 'f') {
                        coders[pos] = String.valueOf(counts[5]).charAt(0);;
                        //System.out.print(counts[5]);
                    }
                    if (character == 'g') {
                        coders[pos] = String.valueOf(counts[6]).charAt(0);;
                        //System.out.print(counts[6]);
                    }
                    pos++;
                }
                Arrays.sort(coders);

                //System.out.println();
                String text = String.copyValueOf(coders);
                //System.out.println(text);
                //System.out.println(encoding.get(text));
                sum = sum + (encoding.get(text) * Math.pow(10, powert));
                powert--;
            }
            sumOfSums = sumOfSums + sum;

        }
        System.out.println("Answer Part 2: " + sumOfSums);

    }

}
