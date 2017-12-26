; inspiration from http://lambda-startup.com/traversing-trees-tail-recursively/

(ns day09.core
  (:require
    [clojure.test :refer :all]
    [clojure.string :refer [replace]]
    [clojure.set :refer [union]]
    ))

(def input "{{},{{{{{},{{<!!!>!<\"<!>,<!!!>!>},<!>,<'e\">},{<!!<}!uu!!!>!!a!!a!>},<!!!!!>ue!>,<\"!!!>!}>,<}!!!>,ii>}}},{},{}},{{},{{<!!!>!>,<i!!'!!{>},{},{<{}}!>},<i<\"{,}{!!oo>}},{{{{<}i<}\"\">},{<o<!>>}},<!!!>uo{}!!'!!<!!!>o!>>},{<!!!!!>!>},<!!!>!>,<>,{<!!!!!>{<!>,<>}}}},{{{},{{}}}},{{<{u'\"\"o>,{<ee!!!!!!!>!!!!e{uea!>!!i>}},{<o{!!!>!!!!e<!>},<!>,<e!!!!>,<>}}},{{{{},{{{<a!!>},{<}<{!>},<!>},<o!e!!},!>!!<u{i>}},{<a{!,!!u!!e}a!>},<u{!!!>},<>}}},{<i,>,{}},{<u!!!>!>eie!>,\"!!!,,!>,<}<eo!>},<>,<>}},{{{}}},{},{{{<!>,<iooi!!ueao!>,<!!!>}!>},<\"ai>,{<u}a{e!<!!!!!!!>!!u{{!{!>},<<{o!>,<!o>}}},{{{},{<<,\"!>},<u!!u'!!!>au!o>,<!!\"!!!>'!!!>,<!>},<'oaaou!!!!!>},!>,<e>},{{{{{},<uo,{eiu,!''!ui\">}},{<!>,<!>},<!a!!>}},{{},{{},<i!i!!,iu!!!>ie\"e!>},<a!>!\"i!>{!>},<>},{{{{<!>,<}}!>},<!!!>},<!>},<!!'!>,<,'!>!!<,}{e>},{<ua!>,<>,<}!>!!!>\"!>},<'!!!>}<>}},{{<a}!!,ee!!!>!>},<a!e!!!>},<>}},{{{},{<}\"a}!>,<!!!>!>},<!!,!>,<<}{o\"\"!!a!!,a>}},{{<>}},{{}}}},{<o!>},<!!<\"!>},<!e!!!!!>!>{>},{<>,<<>}}}}}}}},{{{{<!>},<}}'!>,}>}},{<\"!!!!!>,'<!>!!i}{o!>ai{\"!!!>>,<!!!o!>},<!><!!!>\">}},{{}},{{{{<e!>},<e>,{<}!!!><!>,<!!oia,!>,<e}e!i>}},{{<!!!o!!u!!eu\"{}!>,<i}\"e!!!>}!e>},{<}a'!,}>}}},{{{},<i!!!>!!u\"}>},{<!!\"!,!>!>,<ae{!>},<!>,<!!!!!>i,!i}'!!!!'\">},{{<!>},<!>,<!\"!!{u<ea\">,<\"!>!{}a{\"!!o<\"'!!!>o}{a>},{<eue!!!>},<\"!{<'>}}},{{{{{<e\">},{<!>},<>}},{{<!!<a>}}},{{{{{{<o<>}},{}},<i>},{{<u!!!>!!ua!>oa}uia>}}}},{{<!>,<!!e{e!!!>,<}\"!!!!ei!!!>!>!\"ii}>}}},{{{{<!>u!!!!!>,o\",!!!>!u!>,<>},<ue!!!!,!!!>!!!>!!o!>,<{,!>!>},<>}},{<!!!>'>,{<!!o!!u!>!>,<ia!!!!!>!!}!>,<e!>,<>,{<uu!!!!}!!>}}},{}},{{<>},{<o}!!i{!!!>!>},<a'o!>o!>},<!!!!!>},<>},{{<!!!>,aa!!>},{<>}}}},{{{{},<!!!!!>,<'!>},<!!}!!!>!!<>}},{{<!>},<ai>,{{<!!!>!!!>a!!!>!!{>},<a!>!>},<u!!!!!!!e!!!>!>,<e}>}}},{<'oei!>},<uo{!!!>!{e!>,<i<>,{<>,{<!>,<o!!!!!!'\"\"!>,<!>!>,<!!!>},<}>}}}}}},{{{{<e\"a!}!>,<!>},<!>!!!>},<{!!!>>,{<!>!>\"ua!!!>!!,}'!!ai,e!>},<!!}!!!!i,>}},{<>},{}},{{{{<<!!>}},{<u>}},{<,,o!\"uu\",,!{'>,<!!!o<ii'!>!!!>},<'!i!>},<!>},<!'o>}}},{{},<<u!!!!!!!>!!{!>}\"a>}}}},{},{{{{{{<a!>,<!>},<<>}},{{<}!!!>}!!>}},{{<!'\"'>,{<}!!i!'eu<a,o>}},{{}},{<!>!<e!'a<}!>},<e!!!>ii!!<a!>},<\"!!!>!'o>}}},{{{<!ou!!'e!!e{a!\"!>},<!>,<!!uo<e!!>}},{},{{<!}<!!,u!<!!{<}!!!!!>},<!!u!!!>!!!>}!>,<>},<!>},<eua{!!ai!i!o!>,<!>,<}'>}},{{{<!>},<!'!!!>!>,<!>},<!!'\">}},{{<!>},<{!!!>!\"<!!e!>},<\"!!!!a!!e!>,<!>e}>},{{<!!'!>},<>},<\">}}},{{<<!>o}>}}},{{{{{<>}},{{<!!!>a'>},{<!ui!>,<}i}\"{}!<,e>}}},{{{}},{{<ee!!i!!>,<uue!!!!!>!!o!!!'u{!!!>},<!>u!,!!\"i}>},{{<\"!!}{u'<!>,<!<a!!!>,<{!!!>eu!!!!!>>},{{}}}},{{{{<'i!!},a!>,<o<ii!>!>!>,<!>,<\"!>},<!>>,{<u!>ou},!!!>\"a!!o!{a!!'\"}!!\">}},{{<<!!!><,!!>},{{<!>,<oo>},{<!!!>!!i}'!!!>!>,<uau!\"!>,i!!!>>}}}}}}}},{{{<}uo!!!>i!!ii!>{!!o\">}},{{{{<!!'}!>,!!!>>},{<!'}}}uei>}},{{<,!!>},{},{{<a!><!>},<\"!!!>!!!>'o\"o{!!e'\"a>},{}}},{<o,\"',!>},<,u!>,!!!><{au}!>>,{<u!!a{!><!!!!\"i!!,\"!\"'{<'!<>}}}},{<{!!ee!!!>!!a!i!>ei!!e!!!!!>!!!>e!!a\">}},{{{{{},{{<\"o!!{>},{}}},{<!>,<!>,<!!o!<!>,<{,}{!<{<!o!!!!!>>}}},{{{<!e!!!>{o}i!!i!>},<}'>,{}}},{<i'!!e!!\"!!!>},<!>,<!ao{a!>},<!}!>},<u>}},{}},{{{{}},<{!!},{{>}}},{{{{{<!!o!!!!e!>,<!!'!'!>},<!>,<ie{,,},>},<e!!{'!!!>!!}<!!!>,<!i<>},{{<!>!!e\",\"\"'a!!o}!!!>\"!!!>}>}},{{<!!i\"!!oa\"!>},<{',{a>}}},{{{<eui!!eo\"!!!><!\",!>},<{i!!!!!><!,u!>,<>}},<}!!!!'>},{{<!>,<>,{<!a!>},<!!!>o!!\"'!>,<aoo>}},{{<{<!\"!!!>\"!!o!!!>!<a!!!>!!,>}},{{}}}},{{{},{},{}},{{},{{}},{{{<i!!e!,e!ua'o!!!>!>},<u!!,a>,{<,a!!!>}oa<'ii>}}},{},{<!!!>!!!>{oiu>}}},{{{{{<!!{<!>},<e!>}!!\">,{<<!!\"!>},<!>!>,<<<!o<\">}}}},{{{{{}}},{{<uea!!'!e\"!u!!!>!>},<!a!,a!{<<!>},<!>,<!!!>>}},{{<!>},<>},<!>},<!>\"!>!!!>!>e>}},{{{{<!>,<<\">}},{{<!>,<!i!>},<}!>,<!!!>!!!>,<!>,<!>!>},<,!>,<o!!!!!>o>}}}},{{<!>},<!!!!{i!!,e>,{<o!!i{>}}},{{},{}}},{{<e!>!!!>>},{{},{<!!!>,<u<a!!'!o}i!\"!>},<,{>}},{<,!!!><!>},<!!!!i!!!>},<<>,<u<<!!!!!u<e'\"!!oe,a,!>,<\"a>}}},{{{<,i'\"!!u}!>,<,o!!{!>,<{ou<!!>,<ieeo\",!!<!!a}!>,<'!!}>}},{{{<e>}},{{{<!!!>},!!<o!>a!!!>e<!!!>>,{<,>}},{{<!!{{!>},<!<}}{,i!!!>u!>>}}},{<\"!!''\"!>,<!!!!<>,<}',!>e!>,<a}uo!!!!i\"!>u>},{<<ei{>}}}},{{{<i!!ea!>,<i<!>},<!>,<!>,<!'o{!>!!!>\"!>,<!>>},{{<!>,<\"!>},<!>,<!>,<!><!!!>{!i\"a!e{!!>}}},{{<,,\"!!o!>ei\"''u>,{{<<o!!!!!!o,!i!>!!u!>!>!>,!'!}<u>}}},{{{{{<i{a{a!e!!!>ea!!!!!!!>},<'!>},<>},<!!!>!!,'e!>,<,}!!\">}}},{{<!o!!<a!>,<!>},<!>,<!>},<!!,!>e{<a,u!!!>ie>,{{<!>>}}},{<!>!!i\"u!!!!o!>},<}e!u{!>{u!>},<'i}>}},{<!!ea!,!>,<<oea,!!!!}'!!a>}},{<,!>!!!>},<<!>!!!eu!>!>},<{!!}ao\"iu>,<!!!>'<!!!>e!>!>},<!>},<<!e}eo{}e'>}},{{{{<!!!>,<i!!!>oa<!a'>},<!!o!!!>{e!!!!a!!!>,<!>,<','\"a!!!!!a!u>},{{<!!!>!!!>,<u,!!!>>}},{{{{{<a!>eoi>}}},{{{<e!>!>,<>},<uu\">}},{{<!>,<!\"ei'!!!>!!a!>},<{,}!!!>e!>>},{<a!!!>},<!!{!'eu!!!>!!i!!!>'a>}}},{{<!>,<!'e{!!!eo,oe!>!>},<}\">},<uo!!ou}!>},<e{!!!>'o!!!>}'!!,>}}},{{<!>u{i}>,{<e<!!!>',}!,ia!!i,!!!!>}},{},{}},{{{{{<\"<!!!>e!!!!<a'<!>}!!!>!>},<>}}}},{<{{,\"}!'o!!a!!!>!!!!\"\"{}!!!>>,{}}}}},{{<!>},<o\">},{{<!,!!{!>},<!!!>!>},<}!!!>!!i,!>{!>a!\"{!!!>!!>},<<{!>,<\"o!>,<!>'!><aa!>o}>},{<!>,<u<a!o,!>!i,>,<}<o<a!!!>!>!!o!!!>{!!'o!!i>}}}},{{{<i!>},<!,}!!'\">,{{<!><oi!!!>'<e!>}{!!!!<i!!!>>}}},{{<!>},<!>!>,<u{!,!!,>},<'{o\"!!!!o!>o,<{,o{!!!>,<a>},{{},{},{{<!>,<\"!!{iu\"i!>euoa}!!!!<!u>},{<!>!!u'!>,<\"!!!!<!>},<auu<'u\"}}>}}}},{{{<>},<}'\"o!!!>\"\"!!!>},<',{<!!{!!!>},<>},{{<i!>,<!!!>uao!>},<>,{{<o<!!o<!>},<!>},<,!>i!!!>o<{!e,i>,<o}\"e<!!u<!ii}!a>},<!!'!!'e\"!!!!!>oei!>,<u>}},<,!!!>'!!!!{o>}},{{<'u!!!>!>},<!!oa>},{{{{<!>,<!!!>},<i\">,<e!o{a!>,'!!o!!u>},{}},{{<'!u!!!>\"}!ui!uo!{!!!>!>,<o!!e\"!!!>'e>}}},{},{<ou>,<<'>}},{{<{u'}'!>i!!i!!!\"!!'!>},<!>},<!!!>}}!!e!>,<!i>},{<'a{o!>},<,<!!,!>!!>}}},{{},{{},{{<!!!>},!!!>},<!!!>,e!!!!!>'!!!!!>!!o!!{!!{<!!!>,<>},{<!>},<>}}},{<ui!>,<}>}}},{{<!\"}!>,<,'u'e>,{{}}},{<!>,<i!!!>iae{>}}},{{{{{{<}}o!!,\"{<!!!>},<!>o{!>},<\"!!!>,<!!!><>}},{}}},{{{{<!><!}{a}eu\"}!!!>euu!>,<>,{<,!>},<!!!>!>!>},<e!>{!>},<,!!!!\"!>,<!a}>}},<a{u!>},<{!>,<!>},<,u\"!!u,!!{}ouo>},{{{{}}},{<!ooe,u{!!!>},<i<!!ia!!!>},<!>!!e!!<!>{a>}}},{{<!>},<!>},<!!!>}!!'i!>\"!!e\"',!!'!>>},{{{{{<!!!>!ae!!\"}!>},<<'!}!!'!!!>},<e{{!e>}},<>},<a!!!>,<eu,a<!>>},{<!>>},{{{{<!>},<a!>}u>},{}},<!!,!}}!!o!!\"\"}>}}}}}},{{<e}e!!{!!!>,<a\"\">,{<!>o!!ie}!!>}},{}},{{{{<u!o!>,<!}!!!!}!!!>e!{!e<o!!!>,<,,<>}},{<<}!!<!!!>e!!e!!''oa>}},{{{<!>,i!>,<!!!>!'>},{<oea!>,<\"u!>},<'<!!}!>},<<!>,<!!!!}!!u>}},{<!!o!>,<}!!'!>,<<!i{!e'e!!!>>}},{{{<{!!!>}a!>},<!aou!!'!>},<!>!!!!u<o!>,<'a!>,<>}},{{<!>},<!!i!!!>a!!'!!!>e'!!>}}}}},{{{{{{<i!'{oe<ao>}},{<\"i!>},<!>,<\"{o}\"{!!a!>},<>,<!>,<!!!>!>!>},<!!i,o!!!>!><o\"\"!!ue{>},{{<!!'!>,<<!>,<\"!!!!io{}o\"e!>o!!o}{u>}}},{{{{{}},{{},<!>},<!!'<e{!>}!<!>,<i!!!!!>\"{<'{a>},{{<oeuu!!!!!!}''!!i{>,{<\"'!,!<!!!>},<e,!>,<ae{o!>},<}>}},{}}},{<!>,<!oa\"a>,<!!!>!>,<!!!!!>!!!u>},{<!!{!ou!>,<{a\"eu<i!!,<!>u>,{<'>}}},{<}ia!>},<!!!>!>!!!>!!!!!o!!!>,<!!!>\">,<\"u'>}},{},{{<'!>{a}!>},<!!!>!o!e}!>\"e<!!!!!>!e}!!!>},<>,{<!>},<!!i!!<a!>},<!>},<u{!>,<{!{e!!!!!>a!!!!!>>}},{{{<e!>,{!!!!a<>}}}}},{{}},{{{{<'!>,<o!>{{i!!i!!!>!!!!{!\"\"<ee!!}>},{<}{e!!,e\"'<i\"!!o,eu>,{<<i!!!!}!>,<!>,<e!{i!>},<aa!>,<!>},<'>}}},{{{}},<{\"a!!!>!e>},{{{{<!>!>,<}!>},<!>,<!!!>!!!>!>,<!>,<}!!!{e<a!>,<>},<!>'o!!!!a!>!>,<!!!>},<>},<!ui!o!>}!!ei!!!!<!>},<!!aa}!u!!}>},<<!!ao<u!}<!!e\"!!!!ou<!>,<!!!<>}},{{{<o}<!>},<o\"!>!>},<<e!u,a>},{}},{<<!i'}\"a!!!>},<uo{!>},<!>a\"!!\"!\"!>,<'!!!>,<>,<!!e},!>!!!>,<}!!i!!!}\"!>,<!!!!i!!!>!!!!!>,<>}}},{{<eeu!>,<>,{}},{{<!o{u!!>,<,!>!!!>!!!!!ae!>},<!!!>>},{{},<,',{!>,<<>},{{<'<!!a'{i!!\"i!!!>!>},<!>,<o<\"!!!>!!{<>},{{<a!>}!\"\"a!!!>!>,!!!!!!!>>}},{{<!>},<,'!!uu\"{o!!!>\"ea!!e!>},<u,\"',>},<!{!!!<!!!>u!>i!}}!{<e!!u!>},<!>},<!!!>!>},<{!>,<>}}}}},{{{<!e\"o}e>},<!!!>u!!\"!!!>}a{!!!>oie!!!u!!!>ua,!!o<>}},{{{{{<!>},<!>!!!>!>,<>},<e<>}},{{{}}}}}}},{{{{{{<!>},<!!!>!!!>!!a!o,}i{o!!!>!!!>,<>},<a!>},<!>,<!a!!!>!!!>!o,\"!>euu!>!!!>!>},<!>!>,<>},{{<o!>>},{}},{{<{>},{}}},{{{{}},{{{{},<<{i!!ao!!!>'!\"e\">},{{{}},{}}}},{{{<<'!!!>\"!!!!!o!>},<{'oi!!o!!!>},<>},<o\"ea!!,a!>,<!!!>',!{e{>},{{{<>}},{<e<u'!>,<!>},<!>},<auo}!!!>i>},{<uue,!!ei!e!>,<!!{u{i!>o!!!!}!!!>>,{<eu'a!!o>}}},{<!!!!u,>,{<!!!>!>,<,!>},<a<}\"e,!>i!!!>iei>}}}},{}},{{<!!}i}e!>u<{e<!!}!!!>!!{e\">},<!!!!!!!>>}},{}},{{{{{<<!!!!\"'!!!!!>},<u,o!>},<!!aa!!!!o!!!>},<<<u<>}},{<!!!!!>!!!>i!>>,{{},{<'!>,<o}u}ea}\",!!!!'!>,<>}}}},{{<!!!>!!!>!>,<aa!>,<oe!>},<a!aa!!\"!>,iu>,{<!a{!!!!!\"!!!!!>!!!!!>!au!>'>}},<>},{{<a!>},<\"!o!>},<<!}!>,<!iueeiai!>},<,e>},{{<!!>}}}},{{{{<!>,<!!!>!>'}i!>},<ua\"o!!io<!!!>>,<!>},<u{,oou>},{{{{<!>},<!!!o}!!u\">},{}}},{<!!!!u{}o!a!e'{\"!\">,{<,\"{!!!!,o\"},!>},<!>,<i!!<!>!!\"!!!>,>}}}},{<!{'!>},<!>,<,u\"!>,<e!!!>u>,<,!!!}!>,<a!!!>!\"!>,<>}},{{<i!!}e!!!>{{!!\"!!!!\"!i<a\"'ie<!!{>,{<{!!o!!{!>,<u>}},{}},{{<{e<!>!!!!,,!!e}!e!>,<!>,\"\"!>},<u!o>}},{{{{}},<!!!>u!{>}}}},{{{{}},{{},{{},{<\"!!!>!>,<!!!>,<,e!,a>}},{<a<,{!a!>\"u<>,{<e!!,,!>},<!>},<e!>,<>,<!>,<u{{!!!>!!<}{!!!,\"uo>}}},{}},{{{{<{\"a!>},<!>},<!>,<,>},<!>!!a!>,<}!!!!!>!!!!o!>,<}!!{oe!u\">},{{{<{!>},<!\"o!>o!\",>},<uoi<ee>},{{<}>},<<}\"\"a!!!>},<!u!!!>>}}},{{<o!!!!!>,<\"i!>},<>},{<'>}},{{{<e!!!>,<!>!,e<<!>!>},<<!>o!>},<!!!>!!i!>>},{<,i\">}}}},{{<>},{<>}},{{{},{{{<<!!!>,<!!a!!\"<!u!!i!>,<!>,<u'a>}}},{{<,}'!!!!!!'!!!>},<>,<!!!>>},{<'e!>}}<!!i!>,<o>,{<u>}},{{},{{<u'!!!>,<oi,u!!!>o!>aa>},{<uo,{ia!>>}}}}},{{{{<e{!!!>a!ie>},<!!'!>au!>\"!!{!{i!!i,'{!!!>!!'>},{<!!a}i,\"\"\"},'!!!>!!!!e>,{}}},{{}}},{<'a!o!>},<>}}},{{{<o!!\"'!a,o}o!>!!ae!u!!<e'e,'>,{{<!!}!{u\"!>,<}!!u!>,<!>,<!>u!!e!!\"!o>},<!>,<uu}oo!>,<!>,<!>,<<!!!}!!!!!>>}},{<!!o}!i!!!>e!}'!>,<,!\"u!!ou{}>}},{{{<{!!!>a'!>,<!>},<o{>}},{<}a!!!!,!!<!>io!{>,<}u!>!!!>i!>!eu!>},<{!!}!!!>{!!!>u>}}},{{{},{{}}},{{{{<{<eaa!>},<!>,<!>},<!>,<e!>,<!'>}}},{},{<}!!!>}i!!}u!>,<!>},<e!!u>}},{{},{},{{<>}}},{{{{<e!!!ua!!!>,<<{i!!!>!!>},<{!>},<!>'u\"e<,!!i!\">},{{},{}},{<o!>!>},<\">,{<!!}!!}i>,<>}}},{{{<',<<!!u!>,<!!i!>},<!>!>>,{}}}}}}},{{{{<}e\"!>{!!!>!!,a<e}u'i<\"!>}!<>},{{<aa\"uia}>,{<o,!!!!!o!>,<aaa\"u<!!{!!ue<{!>,<>}},{<,}>,<!>,<!>},<'!!'>},{<!!!>>,{{<!e!!!>!>\"!>,<{ue<'}{>}}}}}},{{{{{<i,!>!!ea!\"!i>,{<!>,<>}},{},{{{{<!!!>,<!>,<,,ii!u!>},<,i!>,<!!!>,>}},<!!!!!!!>!>,<'!!!!!>{!>,<>},{<!\"!>},<!!!>,<\"\"uo!!!>!>\"!!aa,o!uu>,<iao!>},<a!!!>}}!i!!\"!!!!!>!!!>!>},<>},{<>}}},{{{<oe!!{',!>>,<!>},<},!>,<ao!>},<<,{!<!>,<ueu!<!a!!>}},{<!e!!}}<eu!>},<!!<!e!!i\"!!'ui>,<}}!!<>}}}},{{{<>,{{}}},{{<o!!!!{,!!!>o\"u!!!!!!e!!io<!!!!!>},<>},{{<!!!>!>,<o!!!!!><,!!!!'ei!>{>},<e!o!!!>!!!>o!>},<ei!i!>},<uo>}},{{<!>},<'u\"e}u>},<!!!!}!>},<!!!!o!>!>,<!!!!!>!!!>!!!>!!,o!>i!!>}},{{{<!!u!>e<!!!!uu}!>'!>},<!!!>,<!>\"!>!>,<>},{},{<u,!uo<!!,!!!>},<}u!!!a\"!>}>}},{},{{{<!!!>{!!\"!!'!ou!>},<!!!>\"uuio!u{>},<,!>,<!!\"!!,,!>}{!ae'!!!>e}>},{{<!\"<>},<}!!i!i{}i!ii>}}},{{{{{},<a}!!a}!!!!!a!!!>>},{{{<,u\"!!!>aae!u<!>},<u>},<{<>}}},{{{<!!a'<!!u!>},<ei}i'!!\"!!!>},<!!!<<\"e>}},{<!!}a!>},<,'<!!,!}<a!>,<!>,<!>,<<aee!!>}}},{{{{<!!!>,!!!!'!>,<,!!}!!!>!>,<a{,>}}},{}}}},{{{{{<,!!!>},<!!{<u>},{<>,<!>},<'\"!>,<!>,<>}},<!!uo>}},{{{{{<!>},<'i>}}},{{},{<!!!!!>},<'!!!>,<u>,{}}}}},{{<'<!>,<i!>{u,>,{<!!!>!>!ia!>},<uu>}},{{},{<iu!o,!>!>,<!!!>!>,<oa,!!!>!!!>o,o{}o>,{<>}},{{},{{<{'!>},<!!!>,<!!!><o!><e>}}}},{{<}!>!>},<!>},<>}}},{{{{<!!!>>,<e}i!>},<!>,<!!'i!>!>},<a!>,<!>,<o,>},{{{<a{<{<\"!!!>,!!!>,<!>,<!>,<!>,<o,e>,{{<!>},<<,!!!>e!!!>'}!<e,',!>}!><'>}}}}}},{{{{{{},{}},<!>i'!!!>},<}o>},{<{!>i!>},<u!><>,<i!>,<<!>},<>},{{{<{!!!>}!>},<'>},{{{{<u!>},<!!!>},<,}!>,<!!!!}!>}e>}},{{{{<a}!>!!<!!!!a{!!<!!}!!!!!>a'{i!>},<>}}},<!!e!>,<!!!!!>aa{!>},<!>},<!!e!>},<!>,<'!!!!!<,>}},<'e!!{!>},<!!!>!>,<}>}}}},{}},{<!>,<!!a!!}!>}aa}>},{{<!!!>'!{<!>,<!>'u,!>,<i!ui!!!>},<!>,<!!>},{}}},{<}\"}e}!!'!>},<,!!!>}!!}>}},{{<!>,<!!e!!}a>},{{},<<}\"<au}!!ue{{>}},{{<\"!!}},!>,<!>},<!>,<!>},<o{o>},<!!!!'!>},<o,!>,<!>!!e!>,<>}}},{{{{{{}},{{}}},{{},{}},{{{{<!u!!ou{!a{ua!}!!!>>},{<,!!!!!>'!,a'!!i!\"aooo>}},{<'!!!!!{au!!'!eaueuo!!i'!!!!!>{!!e>},{<!>,<'uu!>},<!!!>{!>,<iou!>,<>,{}}},{{<,>}},{{<\"a>},{<'!!<ae{!!!>!>\"!>,<i!>,<i!>},<e>,<!!!>}i!>},<!>},<u!>,<}{,i>},{{<!o>,<ia!!{!<oo{!>},<o>}}}},{{<!>,<!>,<,a!!,!>!!!>'!>},<}!>,<{ua}\"o>},{{},{<o!!!<,!>!}\">}},{<a!>,!>,<o!!!>,ei!>,<!{!>,<!a>,<<o}!\"u>}}},{{{{{{<o'!!ia}uee!>,<\">}},{},{{{{{{}}}},{<o{!><e!!}}!!'}>,{<\"iu!<<,!>\"{<!>au>}}},{{{}}}}},{{{{{{<<!{!!!>,u}a!>,<,!>},<i!!,!!!>i!>,<o!>},<,>,<!!!>!<>}}},{{<!!!>!>!!!>>,{}},{{<i>}}}},{{}}},{{{<>}},{{<u!,!<!>,<<>},<i!>},<!!!>>},{}},{{<!!!>!>},<!>'>},{}},{{<}{e!>},<e,a!>}i!>,<o{!!!>,!!{>,<>},{{<>},<!!!>!>,\">}}},{{},{{{<au!>>}}}},{{{{<!!a!>},<<!>!>},<!\"e,!>},<>},{}},{{<!>},<!!a!ieoe!>},<>},{<i!ii{>}},{}},{{}}}},{{{<!!!>,<,!!!>!!}!!!>,<\"a<<!!ea'!iu{>},{<!!oo!}<a>}},{{},{{<u,!!!>!'!>e!!!>!>},<o'uu!>,<!>,<!!!!!!!!!!!>,<ui!>>,{<!>!!{!!e!>!}>}},<'o!}!>},<!!!>!e<,,<e\"!>},<>}},{}},{},{{{<!!!!e,!!u!!!>}e!!!!io!!<!>,<i<>}},{{{<!}!!!e!!!>'{,!!u}>},{}}}}},{{{{}},<>},{{<{!>,<!!o!<a!!!>iu!>,}!>},<,!>\">}},{{},{{{{<!!oo'!!!>\"!>!!!!!!>}},{<'o}u>,{<}!!i!!!>},<!>},<u!,}!!!>oo>}},{{},{{{<!!!>},<!!i}!!!>,<\"{<!!!!!>{>},<e!!,'!>{!!!>o,,>}}}},{{<}!>},,!!}!!!oi!!>},{{<>}}}},{{{{}}},{<\"!!!>},<{>,{}}}}},{{{<!!<!>\"!>,<!u!!!>!!}!au!!>},{{<>},{<!i!\"!!!>>}},{{<!!e}o!!{u!!!\"a!!!!!>,,ui>},{<,!>,<'!e>}}}}},{{{{<'{}u}u!>,<!>,e!!o!o!>},<}!>}>,<!!!>{!!u!!\"<,!>!>!!\",{>},{{{<!!!>!!!>!>e}!>,<!>,<\"!!}}ii!>!!!>}>}}},{{}}},{{{{}},{<<}>}}}},{{{{{<}!}<!!a!a!>},<>},{{{{}},{{<ii!o!!e!>},<u!!,e!,,o<>,{<!'i,!>,<>}}}},<i!!!!!!!>!!aa!>>}}},{{<{'ia}!>},<!>},<!>},<eai<,>,{}},{{{{<!!!>},<>}}},{}},{<!!au}!!!!>,{<!>,<a}!\"e},a'!{}o!i!!!!\"{>}}}},{{{{<}\">}}}},{{{},{{{{<,{!>{!>},<!!!>},<e!>,<!!!!!!i<!!}i!eu>}},<!>},<u!>\"\"!>,<!>,<\"e!!<!!'!!!!!>!>},<!!!!>}}},{{{<a!>!>!>!>,<!!!>!!!>!>,<>},{}},{{},{{{}}}},{<e!'!!!>},<!!aa,{!!i<,a<!!<>,{<>}}}},{{<\"!e<,i>,<!e!!e!o}u{!<!e!!!!!>ia,uu>}}}}},{{{{<!\"!!!{!>},<!!!>i!!!>!>,<!>!>!!!>!<!!!!!>!!!>}!>},<!>},<e>},{<!!'!>,<u,o!o>}},{<'a\">,{<e<!>},<>}}}},{{{{{}},{<!>!>\"o>,<>},{{},{<>,<e!>>}}},{{<!>},<u!!'!>!>}}>},{{<{!!!!,'e>}}},{{<{eea'!!ui\"a<o}>}},{{<',!>>}}}},{{{{<<e}e,!}!!!>,<i,,!>},<}<,>}},{{{}}},{{<!!!!uo!!!!!>u'!!uaa!!!>},<u}{!!{>},{{<,!>},<i}a\",!!!i!!!!,,!>!e!!!>!!>},{<\"}!!!>\"}!!!><>,{}}},{{<!!!!!>!>,!e!!!>eu,>,{}},{{<!{a!!'<'\"a!>!>,<,!!'},}!!!>},<!u>}}}}},{{},{<a!!>},{{<!!!!<i!!!!!!o}!!,'>},{<!>},<\"io>}}},{{{<e!{<eo!>>}},{{{{},{}}},{<}oo<}!!!!i<>,{}},{}}},{{},{{<o!!!>i!i!oi!>o\"!>,<!!,!'}!>},<<'>},{{},<{u!u!>{<>}}}}},{{},{{{{{{<!>,<{<!!!>!!!>!>,<!>},<,!'{,'}<a!>},<,>},{<i,<!>!{>,<<}!!!>!>,<i!!!>e!>},<{!!!<}!!<},>},{{},{{{}}}}}},{}},{{{{{<{!!!>>},<!a!e!>!\"<\"!><e\">},{},{}},{},{{<{'io!>},<>,{<eoo!!!>},<<!!!!!>!oa'>}}},{{{<>,<!>},<}{a!>,<>},{{{<!>'!>oa!>!>},<!>!!!>!!!>a!>,<!!\">,{<,}<,\"i!>,<\"\"!>!!!!!au!!}i!!>}},{<>,<!!}!!'>},{{{<o}{'!>,<o,}!!!>,<!>,<!!!>o!!!!>}}}},{{<!>!!!>e}i!!!>,<!!!>}}'}<>},{{},{{{<{e!>}!>,<!!!!!>{i!>,<!!!>!>},<!>,<eo<>,{}}},{{{},{<'a!!{\"au!!!>!>{!<}!>!>,<{>}}},{{{<}!\"!!a\"e>}}}},{{<!>},<a!!eoa<!!e'!!!!iua!!!>i!e!!!!!!!>>}}}},{<ei!>,}o!!!!!!!><!}}>,{<!>!>,<!>},<<!!!>},<!!!>!>},<!!\">}}},{{<'o<'>},<>}},{{{},{<a>}}},{{},{{<o\"!!!>'!!ouee<e!>,<!!!>},<<>}},{{{}},{<ao!!'!!!>oee!!!>!>!>},<'!>,<!,a{ao>}}}}},{{{{{<!>!!!>!!u!>},<>},{<,uo!!!>a>}},{{{<a<'>},<!>},<u!!!>,!>,<!!uu}o,<!!!>!!!!!o!,>},{}},{{<ei!>},<}!>iu!!a!!'e,\"\">}}}},{{<'!{,}a!a'!!a!><}!i}>,{<,{aii!u!!!i>}},{},{{<!!!>,<!\"{>},{<aua'!!ea!!}i!!!>,<uiu<o>}}}},{{{{{{<>,{<e\"!>,<,i,!>,<i!>,<'{>}}},{{<\"u>},{<!!a\"u}!>},<{!<!>},<e\"u!!!!!!}!!!>!!e!!!>!>},<>}}},{}},{{{<!!\",!!!>,<u{!'o\"{<!!a!<e\"ee<!>},<>,{<!!u!!u!!\"a'!>,<!!!>{!!!>!!>}},{{<!>!>,<i'!!ooo'o!!!>!>,<\">,<\"i<>}}},{{{<!!!!!!,oa!!a!>!!!>o{>,{{<}i\"i}!!i{a,<<u>}}},{{{<uu!!!>,!!!>!!!>{!><i!!a,{{!{}!>ia>}},<,!i,u!!!>!u!>,<!!u!>,<>}},{{},{},{<<!>e<!!\"!>},<a,!>,<i}<i!!a},>,{<aio'!'a}!!e!!{a'<'\"!>>}}},{{{<!>!!!!!!!!!!!>},<,!!!>!!>}},{<}o\">,{}},{<<}\"\"}!>,<>}},{{{<\"!{'a>,{<!!!a\"{\"{!!!>o!!!!oa!>,<u!!>}},{<,!>{,ii\"u,!>!!!>!!!>\"o\"ui!'>}},{<i>},{{<!>!!!>,<i!a<'!>},<>},<!>,<o!o!>,<i!>>}}},{{<!!!>!>ae<e!!>},{}},{{{<!!e<!>},<u!>,<!>!oie!>!>},<'!!u'!}>,{}},{{<!!!!!>,<!!!!!e!>,<!!\"!>a{ae<}e!!,!>},<!!!!!>!>,<>},{<!>,<u!>},<{a!>,<a!!!>},<e{!!!>>}},{<}!>},<>,<!!!>!!e!u!>'a!!!!!>a!!'>}},{{{{<!\"u<o'!>},<e!\"!>,<!!!>,!>,'>}},{}},{{{{<\"!>,<u!!!>!,!>},<u!>}i,a>}},{<u!!!!!>},<>}}},{{},<!\"i!>},<o>}},{{{{{<'!!{!>},<!!!>!,a,ia!!e!>,<'}!>,<'!!!>,<>}}},{<<!>{e!>,<!>},<!!\"',>}},{{{},{<!!',,{!!!>},<i>,{{{{},{<\"!!!>'!>''!!!>!!{{>}},<eaeu>},<<,,i!>},<o!!!>}i>}}},<',u\"o,'uou!!!>,<!!!!u<!>!!!u!>,<!!!>>},{<\"i!!'<>}}}},{{{},<<!'>},{}},{{<>,{<>}},{<!!{!>\"!!!>,<!>},<,<<}!>},<i!!i<e>,{<o!!uu>}},{<!>!'{o!!!>},<!!\"'!<oo!e!!eo!!!>!>},<>,<!!!a{!>},<e<e\"!!e!!a'!\"<!aio}>}}},{{{{<>},{<!>},<<'e>}},{{{},{{},{{}}}},<!!!>},<!>!!{{u'o!>!>},<!>,<!>},<},!!a}>},{<!\"!>},<!>''o<!o!>,<i>,{<oa!>,<<'<!!!!,!>,<!>,<!!<!!!>!!!>>,{<!><a!!!>i!>},<!'!>},<a!!!>!>},<u>}}}},{{{<!!{!>},<}>},<!>,<!>{!>},<o>},{{{},{{<i!!!!{''!i'!!,>,{{<i\"\"e<!!e!>},<>},{<!!!!!{}{!>>}}}},{{<!!!\"e!!'!>u\"a\"'}e!>}<!!<!!!>>,{}}}},{{<}>,<o{\"{>},{<!>,<u}!>,<!!!!'!!!>!!,!!ue!>!>>}},{{<\"'}\"!!!>>},<!{!!!!!><<\"{<!!!>!>aie\"!>,<\"e!>>}}},{{{{{<},!!!>!!!!a!>,<>},<!>,!>,<<oe>}}},{}},{}},{{<!}!>!!}!!<!>},<!!'a\"!!uo,a\"!!!>e{{>,{{<!>!>,<u>}}},{{}},{<a!>},<'{ii>,<!>},<!>,<,au!},e!}!>>}},{{{},{}},{{},{}},{{},{}}}},{{{{<o}!>,<e>}}},{{<\"!!!>!>,<!>,<!!'<!>},<'>}}},{{},{{{<!!>},<{'{,!'{<>}},{{},{<\"!,!}{{{!>,<>}},{{<!\">,{}}}}},{{{{{<eo!!!>!!oe!>,<!a{!>'!!!>!!!>o>},<!!!>},<a!!\"!o!!!!}'!!ie!!{u>},{<<<!!}'e!!!>!}>,<!!!!!<!>},<}!!!}u!>},<!>!!!>!!!>!!a!!!!!!ou!>!>,<>},{}},{}},{{<oe}>}}},{{{<!!''!>,<ii!<o!>,<!>},<ie!>!>},<!!!>>,{<!!ea!!!>!>\"!>!>,<<!!ue'eu!!!!a>}}}},{{{{<'!}}>,{}},{<!!e>},{{<!!!>o!!\"!>!!>},<!!}ii!{!ee\"!>},<!>},<!!!>u'!{\"!>,<!\"\">}},{{<!!>,<!!!>},<!!!>!!!>!>a!>},<!!<!!!}',!!!>u>}}},{{{{<aui}'\"!!!>>,{<,a<i<uu!>''a,!!}>}},<<!>,<i!>},<>}},{{},{{{<a<!>\"o{'\"{}!!!>!>},<>},{<ia!>,<!!'!>},<!!i!!'e!>e!>},<}\"!>!!!!!o!<!!>,{<,,a!!}!!!uiuai!!!>!!,>}}},<!!!i!>},<!!!o!i>},{{},{{<>}}}},{},{{<!!{<o!!!>,<i!>!!!!i!!,>},{{{<!!e}!!}!>},<<i!>},<<'<>},{<!!!!a!',{<{\"e'u,!{!a>}}},{{<!>,<>}}}},{{},{{<<io!>e}o>},{{{<!>,<!!u\"!!!>!!u!!''>},<uea}a!>!!}iu}>},{<!,!!!!{,!!!>i,!'{au{'!!!eueu>}}},{{<!>,<u}e\"!!!>{!!e>,<!!!!!><!!a!!{'!!o!!!>!>}!>},<!>e!!\"!\"!!!!!>!e}{>},{<o'e!!!!!>,<u!!!>o!>},<'}!>},<!>,<!>a<\"u>},{<\"{!!!>,<<>,{<!!,!!!>},<o!>},<,!!eaa',<{uo>}}}},{{{{<e!!'!!!>}!>},<'!e!!\"a!>!<}!>,<!>,<!>,<u!!!>>},<<!!!!!!<!!!>,<<!>,<oau}>},{{{{{}},{}},{<!i!>},<!!!>!>\"o\",u'!<!>\"!<!!!!!>!!!>>,{<!!!>!!!>'{u!>},<o!'!!ao>}},{{<!><!!}!!!!>},<'!!'!>},<!!!!!>},<!!!>!e<a\"<,!!!>'u,>}},{{{},{},{<!}ii!>,<o<!>}''!!!ae}!>,<\"o\">,<u!\"!!!!!>!>},<!!!!!!\"!!aee}!!!>!>},<'!>},<},a!!!>>}}}}},{{{<!!!>\"i!>!>e!>},<>,{{<'{!!!!<\"a'ou!>},<>},{{}}}},{{<a!!!>,<!!!!u!i\"au<>,{}},{<,!!!>!>},<!>,<!!!!!e!>,<<!u!!>},{}}}},{{<,o!!<!!!>o!}'!!!>},<,!!!!o}!>},<u!>,<ii!>>}},{{{<,!!a!>>}}}}}}},{{{},{}},{{},{}},{{{},<'!!!!!>!!<!>,<'u!!u'!>!!}!>,<>},{{{<}\"u!>!>,<!!!>i<\"'i!i{!!!>!>},<uu!!!i}>},{<{,!>!!oa{,a,'!>},<a>}},{{},<\"\"!>,<!>},<\"!!!>!!!!!\"!>},<o!>},<>}}}}}},{{{{{},{}}}},{{<e!i'}!ei}'u!>!i!!\"\"<!>\"\"e>,<}>}},{{{<!>},<,<!!!!!!!>ue\"eoo}\"!!!>},<!!!!}u!!!!!>!><>}},{{{}},{}}}},{{{{<!!!>!>!>,<!!!>!>},<!>iue!>},<}!>},<}<ae>,<!!!>i>},{<{\",},!!!>!>!!!!!>!!!>>,{<i!!!>i!>,<ui,'}o,'u!!\",!>,<u>}}}},{{<\"}!>},<''{!}ie}!au\"<!>},<!>},<!!,>,{{<>},{}}},{{{<!>!!!>},<o>},<!>,<!{a!>,<'!>},<u>},<ue!>},<,u>}},{{{},<}!>},<,a<'u{,!>u!>!!!>!>},<!>,<o},>}},{{{{<a\"!!!>}ou>}},<<!!<{i>},{{},<!e!!!!\"}'!!},!!}!!!>,<!!!>>},{{<!>!>}!a'!><!>,<!!<!!!a!!i}{!!!>!!!!{>},{{<!!!!oi,!!!o!!!>!!!!<,!>u}!!!!e!!!>!i>}}}}},{{{<!a}!>,<}!a>,<!!!!!>!!,\"}<\"!!,ai!>,<}u>},{},{{<!\"}!>},<u!>},<a{!>,<>},{<!u}!!<!!!>u!!i!!!>!>\"\"\"!'ou>}}},{{{{<aaie!!ieu>},<i\"'}a'a!>},<!'{'!!}!!u<>}}},{{{{<o!\",!'>},<<!!!>!!!!!>},<a!!!!!>a,!<!!}<o}>},{},{<\"'{!>},<!!\"!!!>u!!!>!'!}e!!aaa>,{}}},{{{},{},{{},<!!<{{!!!>},<>}},{{{{{{<a'i'!!,u!!!>''{<a!oo!>},<>}},{<!,i\"!}!!!>ei!>},<\"e!!!>!!oo!>!!i>}},{{<!>,<{ioi!>,<>,<,>},{{{<!!!,iiau{{e!>eu'<!><>,<!u}!!!>!>!!a,>},{}},{<!>},<{!o}'!!!!!!!>u!>!>u!!!!\">,{<!!\"!'!i{!{a}>}},{{},<}>}},{{}}}}},{{}},{{<!>,<!!eu!}\"a!!i!>{}oa!!!>!>,<o!>,<\"!!'>}}},{{{{}},<!>!e>},{<u!>,<!>,<!!!>!>,<<<!o!!!!'{}e>}},{{<!!!>,e!{u<\"!!'!!ioo},ei!!o,!!!>>},{}}},{{{<!!!>,<!{!!!>>}},{{},{{{<!\"!!\"!>!!!!!>!>}!>},<!,\"!!!i>}}},{<<!!,!>},<!\"<\"o>}},{<{>}}},{{{<!>},<>,<i!>!>,<a{}oa>}}}}},{{{{{<{!u<!>!!!aa<!!!>,<!>},<e!!a'a!>,<>},{<<!>},<ii}\"<<>}},{{{{{},{<{\",\"!!<!!!>,<a}!>o}!!,i!!u>,<a!>,<<!!!>,<a!>a!!!!!>!!!>},<!!!>!>},<e!}i>}},{}},<!>!,'u!>,<<oo>},{<>,<>}},{<u>,<o!!!>e!<o!>,<u,{\">}},{{{{{{<}{!a\"!>},<a!>},<!!!>!!!!u!'!>,!>!>,<e>}},{<!>,<\"}iu!!!!!>!}>}},{<{o{!}>}},{}},{<>,<>},{{{}}}},{{<,!><{ii}!>,<ii!>!>},<\">},{{<'<!>},<!>,<>,<o!>},<{!!''}u!>i>},{<!>},<{<e!ii!!}>,{<!!!>>}}},{<!!!!!>!{!>},<<<{au!!!>e!!'!>,<,{i,>,{<!>'},!!u\"!e!!!!!>!>!,u,{!>,<!!u!!!>>}}},{{{{<u!>{a'<\"!>,<e!!!>e<o!!a!!!>!!\"!!!!!>>},{{<ei{>},{<u<}>}}}},{{{{<'\"o{!i!<,!\"!<oi>,{<\"!!o!>,<u\"!>!>!!!>{!>,<!>,<!!u'>}}}},{{{{{<!!!>,<!>},<o!!!u'ea!!!>},<uu{u>},<ou!{''!>'\"}!>{'!a!>,<!>}>},{<ai{'!>},<!>iu!u>,<o!>oa{'>}},{{{{},{{<!!}!!<!!'ui>}}},{<{!!'>}},{{<>}}}},{{{<e>}}},{{<ou!!}i!u!!!>}!!\"!!>,<',!i!<!>,<<!!!>!>,<!!!>a!>},<!>,<{!!!>{>},{{<e!!!>{!}e<'!>,<!!ui\"'!!i>,{<uiu>}},{{<!>,<!!!>!>!><!!\"\"'!!!>,<>}},{{{<!>!!!>!!!>!'!!a{a!>},<!!!>},<!!!>}eae<a>}},{<!!!<oi!>},<i'!!<\"!!,e!>},<o!!,a!>!!>,{<'u,aeu!>},<eu,aa>}}}}}},{{}}}}},{{{{},{<{!,>}},{{<!!u}!!!>ui\"!!i'au!>},<!i!>e!!!>>},{{<!!{{!e!>{!>},<!>!}\"!>!>,<!>!!!'iee!!}>}}}},{{{},{<\"!!,aa<u!!!!,!{>,{}}},{},{{<!>,<!!{{{!!!>'!!!>!!<}!>,<u!>,<>}}},{{{<<i!!!!!!\"!{!>},<!!u'u!aoe<<!!!!!>iu!!a!>>},{{{<\"i!!!>>},{{<!>,<!!o!u!!!!o!!!>e}!>,<\"!>!o}!>,<!!\"<oo<>},{}}}}},{{<!>,<!>},<!o!>,<aoea!>},<!>eo!!e!u'!!!!!>{!!!!!!\">,<{!!!>,<!>o!!u\"!!!>e>},<i,o}!!!>!>,!!!{'!>},<i<!!!>\"i<o!>,<!!!!>},{<!>,<>,<{aau{!!'\"!!!!!i!!}<i{ue,>}}},{},{{{{{<!>,<'!>>}},{{{<!>,<{>},{<o>}},<}e>}},{<!>},<{}},u!!}!{<o}!!!>},<!>{i'!>},<>},{{{<<ia<!\"<<!!e<!!!>{'!>,<\"!!,!}>}}}},{{{{{},<e!>},<{,u<>}},{<\",!!!>!>},<\"!!o!>!}!!!!i>,<!>e!!!>},<}!!!>!!!!!>!!!>a!>},<a>}},{{<eo!!,!!e',!{<{u!>,<{>},{{<!>},<!>!!}!!i{!>,<!!!>>}}},{}},{{{},{}},{{<,o'\"{}!>},<u>,{{<!ua,o!>!!io!!!>!>,<!>},<!>u!!\"{!>},<e>},<!>!!{o!!!u}\"!!!>u!i<e!>},<o\"'u,!o!>,<>}},{<ou!!>}}},{{{<o>},<''!u!>,<,!>!}\"!>!!!>},<!e\"!>!>},<>}}},{}},{{{},{{{{{<!!\"}u'!>},<'!!!><!!'!>a!o!>},<>},{<!!'<!!<!>!!!>u!>,<!!}u'<iua!}!!\"!!>}},<\"}!>,<!>},<!e!!!>!>,<!e>},{{<i!>},<{!>!>o<u!>iia!!!>,a!!u!>!!a!>},<>}}}}},{{{{<>}},{{{<u!}\"!>},<<o!!!>,<},e<>}},{{{<{!>,<{>}},<>}}},{{{},{{{<i<!>},<!>,<'i!>},<u}\"}!!!>!!!>!!{}>},{{<,ui!>,<au!ae!>!!}<!!!>}!'!!!!!>>}}},{{{<i,!>},<,{!!\"<!>,<u!>},<!!<<!\"uu,ie>,{<!!!>},<'\"!>},<!>!>},<!>},<!!!>},<{!>},<o!!\"!>'aa>}},{<o!!ea!!{{a!>,<!!!!!!!>a!!!>!!a'}>}},{<''!\"e{<!o!>,<!!e!!i!>,<>}}}}}},{{{{{{},{}},{},{{<!!!>},<,!!,o'<!>!!!>ea!>,<!!!>!!!!!!!!!>,<>}}}},{{<i<i\"}!!!>!>},<!>a!>,<!>,<!!!!!>\"!>,<aa,o!>>,<!!\"!>u!>>}},{{{{<<!>!>}!!!!!!!!!!e<<!!!!u<<<!!!!}!\">,{{<!!!uuia!!!>o!!!>!!!>'\"e'>},{<!>,<!!!!>}}},{{<}!>},<!!!!!!<!>{!>},<!}!>>}}},{}}},{{<e!!aou\"!!<!\"uoao!!!!<'!>,<\"\"!!!!!>\">,{}},{{<!>},<!>,}}uoou!'!>},<'>}}}},{{{{<!>,<!!e!>,<<!!\"a'!>,<!!i>,<<!>!>,<o>},{},{{{<!!!>!!!!oe!>\"\"<u!!u!'{i!!!>},<,>}},<,!<!>e!<>}},{<!!!>,<\"!!!>ii}\"!!o!!!>!!!{!i!!!>},<\"!o!!u!}>},{{{<'!!\"!>ea'}!>},<>,<}!>,<<o!!!>>},{{<!>},<!!!!!>,<i!>,<!!!!\"\"<u!>},<ua!o!!!>,<!>,<,<}>}},{{{{<\"}!!e>}},<}!>},<!!!!!>!!!!\"\"e'!!!>u'!!!i!!!>!!!o!>,<!>,<>}}}}},{{{{<!>!>},<{!>!!{>},{{<a\"!}i!>u<!>!>},<!!!>>}}},{{}},{<e!!!!!>a>}}}},{{{<!!}!!!!!!!>}i>,{<!u'!>,<<!>!!'i!!,a!a}>}},{{{}},<!!!>>},{{{{<!>,<!!!!uu!!o'!>,<<i!\"!u}!i!!{>}}}}},{{{<{<u}!>,<u'<'>,<'!>,<!!e'!a!>!>},<,>},<oa<!>,<>},{{<!u'!!!>},<>,<u\"!>,e!>},<}\"!>!{!!!!}i!i!!!>u>},{{{},{{<!!!!>}}},<ao!!!>}a,{'!>,<{>},{{<ao<>,<\"u}>}}},{{<'u!>,<!,a'!>},<<!>},<!!!>>},<<!!!>{e>}}},{{{{<{ouu<!!a>},<!!!!{!>,<e!>!!e}i!!a!!\">},{<!>},<!!!!}!>!!!!!>},<u!>},<ea!!i!!i>},{{{<!!!>>},{<!>{a!>,<!!u'!!{!!i!>,<o,!>,<!>!!e!>,<>}},{{{<!!}{!!!!,o!>a'a>},<>},{<aa!>,<!>!\"!!!>,<!>,<e',!>>}},{{{<u!!!!!>{<'a!!a!iae}u!!!!a!!\"!!!>'!>},<>}}}}},{{{{},{<i<ao\"},!!!!!!!>!'>}}},{{{{},<{,oaa!>{<eo!>,<!},oei,oe>}},{{{<!aoe{!>!!\"{>},<o!>},<o>}},{{<'!ia!!!>>}}},{{<!>ea!!<!>,<}!>!'i\"!!e'}!{!!>,<!!ioo'!!!>,<a!!!>!!{<!'u!<i!!!!o!!!!!>!>!!!>},<!!>}},{{<{}!!!>\"!<a!!u!!{!!{e!!'>},{{{{<{e'e\"!>},<!>,<!>,<',!o!!!>,!!!>oe<o!!>,{<'!!!>!>!>,<o>}}},{{<'!>},<!!o!!!>u!>!!!!{!>},<{'!>},<\">},{}},{{<'!{\"!!!>!!\"\">,<'ei\"!!oa>}}}},{{<!!!>!'e\"i{i!!\">},{}}}}},{{{{<\"i>,{<i\"a!!i>}},{},{<!!!>o>}},{{{<!>!!!>},<ua!,!!}!!!>!>,<u<'>},{}},{<a{a!>},<!!\"!>,<>,{<!e\"a>}},{<u}!{!{i!>!>o\"!>},<i>}},{{{<}!!'o{!>},<!!<}!!oe!!u!>},<!u>}},{{{<o!>,<!!<>},{{<a!>,<!,!!u>}}},<!!!>,<'o},a{!>u!!!>},<e!>},<!!!>!>,<e!>},<>},{{{<<e!!!><iu<>,{<o!!!>},<io!>},<},!!}!!!!!>\">}}},{<>,{<!>,<!!!!!>!>!>}!>,<a!!,ae!>},<e>}},{<!>},<!>o{<}!<,e!>,<!!!>>}}}},{{<!!,<!!,!>'!>\",u,!}<,!!!>},<>,{{},{<uo\"{!!!ou!>,<}o{<!>\"!!!!u!!o!>o>}}}},{{{},{<'!e'!!!>!!!>a!>},<!>!!!!i>,<!>!!!!!!!>!>,<\"!!!>!\"',}uo\"!!<!>o>},{{<a'!!!>!>a\"o',>},{{{{<!>},<}!>},<!!\"a!>},<'!>,<>}}}},{<o,!!ua'!!!!ai!>,<!!!>!>!!!>!!i>}}},{{<o!!!!<,,!!!><{oa<}ou!!aa!!!{>,{}},{{{<{!!e}e!>!>,<!{!>,<!!o!!!>!!!><>}},{}},{<>,{<!>!>},<!!!>!!!!ae''!!\"u!!!>,<!!!!'!!\"!i!!'{!!'>}}},{{<}oi\"uue!}eiu>,<!>{!!}o,>},{{},{{<}!>,<!!i{!!!!!a!!{\"\"e<,!!!>},<!!!>!!!'>},{{<!!\"!>},<!!!>o>},{<,!\"'!>'e'!>!>},<!!!!!>\"!>>}}}},{<aea{,!>>}}},{{<}!>},<'!>,<!!!>!!}!>,<!>,<e!!,<>},{{{<!!\"!>,<o<>}},{{{<!!!>u<!>,<o!!o!!!>>},{<!!a!<!!{!!!>a'!!i!!!>u>}},{{},{}},{<\"o!!'<<!>,<<!!\">}},{<,o!!!>!<,>,{}}},{{<}>},{<\"!!o'!!a!!!>'>},{{{{<e'!>,<a!>,<o'o!!\"<>},{<!>},<>}}},{}}}}}},{},{{{{},{}},{{<!!,!!!!o\"!!!>,<!!i,!>,<}o'!>,<!!!>,<!!!>>,{{<!!!>!!!>}}{!!!>!!i!>},<>}}},{}},{<<!>,<'!!!>ei!>,<!>},<!>},<>,{}}},{{{<!!!!!o}!>},<}!<'{!au!!{!!}>},{<'u!!{a,!!'!}oo<o{i{>}},{{{<'!!!{!!!>!!a!>>,<'<\"'!i}o!u>}},{{<!oe!>!!!!!>a}!!!!i!!!>}>},{<u!!!>>}},{{{{<u!>,<>},<,!u,!!e{!!i!>,<,!>},<!!!>!\"!!!>>},{},{{{<,}}\"!!!>u<>},{}},{{<!!!!!>!!<>},{<o,'>}},{<{!>},<!>},<eu!'e!>,<i{!>,<a'!>!<!>{!!!>},<o>}}}}},{{},{<a!}>}}},{{{<!!i>},<{}'<!>{}!!ao,<i!!!\"\"!!!>>},{{<!>,<!!ai}{o,\"o\"!i!{!!}o}>},<{!!<eia!!ue!!!>!>u!!!!!>,<<e>},{{},{<,>}}}}}},{{{{{{<!>},<!{e!!{a<!!!!}!>ui!!}!>ao!,>,{<!><,o'a!!!!!!!>'i>}},<!>,<{au!a!>,<!!!>,<>}},{{{<!!!>,<!>,<!>},<e>}},{{<\"!!u\"!!!ao'>,{<u<}!!!>},<<au\"!!!>o!!!>e<!i}!!!!!>>}},{{{{},{<ie>,{<!>,<>}}}},{{<iea!u!!!>},<\"{>}},{{<u!<,u!>,<a!!!>!>,<!>,<e>},<{>}},{{{<!!u!!'o}!>,<>},{<{!>,<oe,!{o!!!>!!a!!e!!',i>}}}}},{{}}},{{<!!!>!>},<!!!>!>,<'o<,i'!>,<u,}!!<!!!>,<,!uo>,<!>,<o{{i!!!!!>'{i!>\"!>},<!>,<}!'!iu>},{{<!>},<e\"o>}}},{{}},{{{{<a!!,!e{i!,,'ioe!!a!>},<,!>},<ii<e>},{}},{{<e>}},{{<!>,<!>eee!!!>!>},<!>,<\"!!>},{}}},{{{{<!i!,,!>,<a!}'\"!>},<!!!!!>},<a!,a\"\"<{>,{<!!'!!!><u!!!<!!!>!>!!!>'!>},<!!!!>}}}},<!'au!o,aai!>!>,<!!}a!>}u!!>},{{},<a!>},<'o!!!>{!!!>},<!!!>!>},<,\"!!!>i'>}}},{{{<,!!<!>},<!>,<,!!!!!>,<!>!>,<!!!>'!>},<>,{<!!!>!ai!>},<!a'>}}},{{{<ei!!,!>,<!!}{u!{!>,<<!!!>'!\"},>},{}},{{},{<ou,!>ao'{!}<>}}},{{<\"a!!!<',!,ou>,<a!>},<,!}\"!!!i!>,<<!',!>},<!!!>},<>},{{{<!!{}\"!>},<a\"!!!>\"!!o\">},{{<}!>},<!>,<a,e!!o,!!!>o!!e{,<{>}}},{<<!>>,<!>,<}!>!,ouiou!!'o!!!!!>i{>}}},{{{{<\"!'}>}},{<!>},<!>,<!>!!!>au!!}e!>>,<\"!!a!!!>,<!o,>},{<!!}!>},<<u!>},<{>,{{<!>},<a!aa<!,{!!!>}\"{\"!>,<!>},<>}}}},{{},{{{{<!!e!!u<o!!\"!>!>},<\"\"'o!>!>>}},<!!!><<!!!>},<{!!!>o!!{'!>,<!!<!>},<!!!!a!!u}!!!!<>},{{{<<oo!>,<\",au!!!>!!\"!>!!!>!>},<'e!>u>}}},{{<i!a!,!!!>!!!>,<!!!>!o!<ai!>},<<!!!>>},<!>!>,<!>!>},<!>,<!!'!>},<!>},<!!o'>}}}}},{{{<>},{{},<,!>},<!>},<!>},<o!>,<!!{a!>,<o>},{{<<e>},{<!>},<!!<u{!!>}}},{{{},<!!}o!!!>>}},{{<!!!>o>,{<!>,<!>,<!!!>!>!!e!!!!}'>}},{{<o\"i!!a!!!!>}}},{{{{<!!o!>,<i}<!>,<!>,<\"!!!!!>a{,!!!!!!\"a'>,<uu}>}},{{{{<!!!!e>}},{},{<!>,<!!!>}!!<a!>},<'ou!>,<!u!>,<i>}},{{{{<!>,<i{,<!>,<,!o}\">},<!!}\">}},{{<}!!,!>,<ae!!,!!!>\"!>,<!>},<a!e!!!>a!'!!!>!!!>>,<o,a!>}e!!u!!!>}}<!>},<<>},{<{,>}},{{<a}!>},<!!!!!>'!>!!!>!!>}}},{{<i{{!!!!a}e!!,{!}!>!>},<!!!!!>!>,<'!!!>'!!e!!{i>,<!>},<!!!!!!!>\"i!>i'!!,e!>,<!'!>},<}<!>,<o>},{{{<\"!!<u!!!e}o,!!!>},<,!>,<o>}},{{},<\"!!i!!!>,<!o\"<o!io>},{{{<}{!>,<!}oo\"!ui\"},,!!!!}<!u>},<>}}}},{{<!>,<!!e!!!>!>,<!>,<'o!>,<,<a!!>,<!!!>!!!>i!>},<!!<!>},<!!!!!!!>!>!!!>,<!>},<!>},<}o'!>,<e!e!>,<>},{<!>,<!!!>,<,!!!>u!!!>,<a!<iiia!,e!!!!a!!\"o!!!!!>>},{{<!!!{'!<!!!>!,{!>},<e!,!>},<a>,<!!!>e!'<a!!!!!>oe!>,<'!>},<a!!o>},{{<ae,!>},<}\"!!!>!>,<!>,<i>},{{}}}}}},{{<>},{<{!>!>!!!>!!!>!>,<!!!!!!!!<!{<!!!>>}}},{{}},{{{{}}},{}},{{},{{{},{<{!>,<''!>,<'<i!!!!!!!>,<!>,<!!!>>}}},{{<<!!!>e,!!!!a!!<\"u{!>},<!!,!>},<!>},<'>}}}}}},{{{{{<!>},<!>},<!!!>!>,<>},{<oa!,'!!<u}{o!>},<o!>},<}>}},{{<{!!\">},{<<>}}},{{{},{<!!!!!\"u!>'!>!!'i!!!>},<ei>}},{{<!>!!>}}},{{<!>},<e\"ea<!>,<u!!!>,<!!!>a,>,{{<!>},<,{e{!>,<i{!>}e!>,<!!''a!!ii>}}},{}},{{{{{{<{e!!!>!!!>!!!>,<!>,<\"{>},<<!!e{\"!!i,}!!,ou!!!>}<<!!>},{{<!>},<}!!!>'!!ee!>!\"a!!a'a!!!>},<!>!>},<>},{<a!}!'a!>!!!>!!!>!!!!!>!{!>>}},{}},{{<!!!>{ue<i!!e'!>\"\"!>,<>}},{{<o\",!>},<e!>,<!!!!\"!>},<auui<\"!!!>,<!>},<>,<>},{{{<o!!\"!>}o!!\"i!>,<\"!!!>{\"o!!!>>},<!!a<!i}}\"!>,<\"!>},<}!!o'!>{e\">},{{<i!!!>!u<!!',e{>},{<!!!>',!!!>!eo{oe!>{>}},{{<!>!!!>i!!!><u!!!>!!!}'>,<o!>},<\"o>},{},{{{<}a!!}!!}u!>,<oa\"{\"!!!>e'!!!>,<<!{!>,<>},<}!>!>},<!>!>},<,},o\"u!!!!!'{!!!>>},{{{<!!!!i<}a!><a\">,{{<{}'>}}},{{{<o!!!!!>u>},{{<>},{<{!>},<>}}},{{<!!!>!}!!!>!\"!>},<\"<<>,{<!>!},!!!>!>},<!!a'ao'i!>},<o!!!>>}},{{<a{\"oi!!'!>},<<!>},<>,{<>}},{<o\"o{{!>},<uo\"!>},<!>,<}u>}}}},{<}'!>},<<\"u!!!>!o!>a>,{<'{a>}}},{<<,!!{!!!>,!!,'ua!!!!!!!>,<!>,<!!,<!>},<'!!!!!!>,{}},{{<\"e!o!!a,!>,<!ei!!!>!u{<>,<!>,<!>,<!>},<a!>,<<!!!>a!>},<!u!>,<}o>}}}}}},{{<!><'{!>,<}\"\"!>,<!!!>!e\"e>},{<!<!!!>>}}}},{{{<\"!!!,u,!,!<}<!>,<!ao!>>},{}},{<!\"\"!>,<!>,<}'{\"!e'o!!a!!!>!!{}!!!!>,<ooi!>},<a<!>>},{}},{{{{},<!>!>,<i!!!>,<'e!!!>!!o!>!\"!>},<!!!>},<\"a!>,<'>},{<u<!>},<!!{>,{<'o!>!<!!e>}}},{{{<e!>},<!>,<,}i!>,<{!>},<o!>},<},<>},{{{{<!,!!{!>},<,,{!>,<!>},<',u\"!o>},<e,>}},{<'i!>},<a!!ao!>,<u!!u'o!!\">,{}},{{{{}}}}}},{{{{{}}}},{},{}}}},{{},{}}},{{<a'!>,<!!!>!!!>!!u'i!>!!!>!!!>u{!>},<!!!>!!!!!!!>>,{<!ao'i}!<>}},{{},{{{{},{<!!<!!i,}>}}}}},{<<!{>,<i!>!!!>'}eu<}!ii!>,<e!>,<'i}!>o>}}}}}}")

(defn remove-ignores
  {:test #(do
               (is (= (remove-ignores "<{!>}>") "<{}>"))
               (is (= (remove-ignores "<!!!>>") "<>"))
               )
   }
  [input]
  (replace input #"\!." "")
       )

(defn remove-garbage
  "ignores should be removed before calling this"
  {:test #(do
            (is (= (remove-garbage "<{o\"i!a,<{i<a>") ""))
            (is (= (remove-garbage (remove-ignores "<!!!>>")) ""))
            (is (= (remove-garbage "<random characters>") ""))
            (is (= (remove-garbage "{<{},{},{{}}>}") "{}"))
            )}
  [input]
  (replace input #"<.*?>" ""))

(defn prepare-input
  [input]
  (->> input
       remove-ignores
       remove-garbage
       (#(-> (replace % #"," " ")))
       (#(-> (replace % #"\{" "[")))
       (#(-> (replace % #"\}" "]")))
       (#(-> [(read-string %)]))
       )
  )

(defn total-score
  {:test #(do
            (is (= (total-score (prepare-input "{}")) 1))
            (is (= (total-score (prepare-input "{{{}}}")) 6))
            (is (= (total-score (prepare-input "{{},{}}")) 5))
            (is (= (total-score (prepare-input "{{{},{},{{}}}}")) 16))
            (is (= (total-score (prepare-input "{<a>,<a>,<a>,<a>}")) 1))
            (is (= (total-score (prepare-input "{{<ab>},{<ab>},{<ab>},{<ab>}}")) 9))
            (is (= (total-score (prepare-input "{{<!!>},{<!!>},{<!!>},{<!!>}}")) 9))
            (is (= (total-score (prepare-input "{{<a!>},{<a!>},{<a!>},{<ab>}}")) 3))
            (is (= (total-score (prepare-input input)) 21037)) ;first answer
            )
   }
  [input]
  (loop [[node & nodes] input
         next-level []
         acc 0
         level 1]
    (cond
      (not (empty? node))
        (recur nodes (concat next-level node) (+ acc level) level)
      node
        (recur nodes next-level (+ acc level) level)
      (and (not node) (not (empty? next-level)))
        (recur next-level [] acc (inc level))
      :else acc
      )
    )
  )

(defn garbage-count
  {:test #(do
            (is (= (garbage-count "<>") 0))
            (is (= (garbage-count "<random characters>") 17))
            (is (= (garbage-count "<<<<>") 3))
            (is (= (garbage-count "<{!>}>") 2))
            (is (= (garbage-count "<!!>") 0))
            (is (= (garbage-count "<!!!>>") 0))
            (is (= (garbage-count "<{o\"i!a,<{i<a>") 10))
            (is (= (garbage-count input) 9495)) ; second answer
            )
   }
  [input]
  (->> input
       remove-ignores
       (re-seq #"<.*?>")
       (map count)
       (map #(-> (- % 2)))
       (apply +)
    )
  )
