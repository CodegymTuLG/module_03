<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2022/12/10
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="./css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<header class="row navbar navbar-expand-lg navbar-light bg-light" style="height: 7%">
    <div class="container-fluid">
        <img src="img/logo.png" style = "height:50px">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <h4 class="text-success">FURAMA RESORT</h4>
                </li>
            </ul>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <h5>User Name</h5>
                </li>
            </ul>
        </div>
    </div>
</header>
<nav class="row navbar navbar-expand-lg navbar-light bg-info" style="height: 7%">
    <div class="container-fluid">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-5">
            <li class="nav-item">
                <a class="navbar-brand" href="/views/home.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="navbar-brand" href="/employee">Employee</a>
            </li>
            <li class="nav-item">
                <a class="navbar-brand" href="/customer">Customer</a>
            </li>
            <li class="nav-item">
                <a class="navbar-brand" href="/service">Service</a>
            </li>
            <li class="nav-item">
                <a class="navbar-brand" href="/contract">Contract</a>
            </li>
        </ul>
        <form class="d-flex mt-3">
            <span class="bg-light ct-search-icon">
              <div class="mt-2">
                <svg fill="currentColor" viewBox="0 0 16 16" width="1em" height="1em" class="x1lliihq x1k90msu x2h7rmj x1qfuztq xcza8v6 xlup9mm x1kky2od">
                <g fill-rule="evenodd" transform="translate(-448 -544)">
                  <g fill-rule="nonzero">
                  <path d="M10.743 2.257a6 6 0 1 1-8.485 8.486 6 6 0 0 1 8.485-8.486zm-1.06 1.06a4.5 4.5 0 1 0-6.365 6.364 4.5 4.5 0 0 0 6.364-6.363z" transform="translate(448 544)"></path>
                    <path d="M10.39 8.75a2.94 2.94 0 0 0-.199.432c-.155.417-.23.849-.172 1.284.055.415.232.794.54 1.103a.75.75 0 0 0 1.112-1.004l-.051-.057a.39.39 0 0 1-.114-.24c-.021-.155.014-.356.09-.563.031-.081.06-.145.08-.182l.012-.022a.75.75 0 1 0-1.299-.752z" transform="translate(448 544)">
                    </path>
                    <path d="M9.557 11.659c.038-.018.09-.04.15-.064.207-.077.408-.112.562-.092.08.01.143.034.198.077l.041.036a.75.75 0 0 0 1.06-1.06 1.881 1.881 0 0 0-1.103-.54c-.435-.058-.867.018-1.284.175-.189.07-.336.143-.433.2a.75.75 0 0 0 .624 1.356l.066-.027.12-.061z" transform="translate(448 544)"></path>
                    <path d="m13.463 15.142-.04-.044-3.574-4.192c-.599-.703.355-1.656 1.058-1.057l4.191 3.574.044.04c.058.059.122.137.182.24.249.425.249.96-.154 1.41l-.057.057c-.45.403-.986.403-1.411.154a1.182 1.182 0 0 1-.24-.182zm.617-.616.444-.444a.31.31 0 0 0-.063-.052c-.093-.055-.263-.055-.35.024l.208.232.207-.206.006.007-.22.257-.026-.024.033-.034.025.027-.257.22-.007-.007zm-.027-.415c-.078.088-.078.257-.023.35a.31.31 0 0 0 .051.063l.205-.204-.233-.209z" transform="translate(448 544)"></path>
                  </g>
                </g>
              </svg>
              </div>
            </span>
            <input class="form-control me-2 bg-light border-light ct-search-textbox"
                   type="search" placeholder="Search" aria-label="Search">
        </form>
    </div>

</nav>
<div class = "row" style="height: 81%">
    <div class="col-3">
        <ul class="list-group vh-79 left-nav-scroll">
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
            <li class="list-group-item">An item</li>
            <li class="list-group-item">A second item</li>
            <li class="list-group-item">A third item</li>
            <li class="list-group-item">A fourth item</li>
            <li class="list-group-item">And a fifth one</li>
        </ul>
    </div>
    <%--    body--%>
    <div class="col-9"> <h1>Sun</h1>
    <p>The Sun is the star at the center of the Solar System. It is a nearly perfect ball of hot plasma,[18][19] heated to incandescence by nuclear fusion reactions in its core. The Sun radiates this energy mainly as light, ultraviolet, and infrared radiation, and is the most important source of energy for life on Earth.

        The Sun's radius is about 695,000 kilometers (432,000 miles), or 109 times that of Earth. Its mass is about 330,000 times that of Earth, comprising about 99.86% of the total mass of the Solar System.[20] Roughly three-quarters of the Sun's mass consists of hydrogen (~73%); the rest is mostly helium (~25%), with much smaller quantities of heavier elements, including oxygen, carbon, neon, and iron.[21]

        The Sun is a G-type main-sequence star (G2V). As such, it is informally, and not completely accurately, referred to as a yellow dwarf (its light is actually white). It formed approximately 4.6 billion[a][14][22] years ago from the gravitational collapse of matter within a region of a large molecular cloud. Most of this matter gathered in the center, whereas the rest flattened into an orbiting disk that became the Solar System. The central mass became so hot and dense that it eventually initiated nuclear fusion in its core. It is thought that almost all stars form by this process.

        Every second, the Sun's core fuses about 600 million tons of hydrogen into helium, and in the process converts 4 million tons of matter into energy. This energy, which can take between 10,000 and 170,000 years to escape the core, is the source of the Sun's light and heat. When hydrogen fusion in its core has diminished to the point at which the Sun is no longer in hydrostatic equilibrium, its core will undergo a marked increase in density and temperature while its outer layers expand, eventually transforming the Sun into a red giant. It is calculated that the Sun will become sufficiently large to engulf the current orbits of Mercury and Venus, and render Earth uninhabitable – but not for about five billion years. After this, it will shed its outer layers and become a dense type of cooling star known as a white dwarf, and no longer produce energy by fusion, but still glow and give off heat from its previous fusion.

        The enormous effect of the Sun on Earth has been recognized since prehistoric times. The Sun was thought of by some cultures as a deity. The synodic rotation of Earth and its orbit around the Sun are the basis of some solar calendars. The predominant calendar in use today is the Gregorian calendar which is based upon the standard 16th-century interpretation of the Sun's observed movement as actual movement.[23]</p>
    <h2>Etymology</h2>
        <p>
            The English word sun developed from Old English sunne. Cognates appear in other Germanic languages, including West Frisian sinne, Dutch zon, Low German Sünn, Standard German Sonne, Bavarian Sunna, Old Norse sunna, and Gothic sunnō. All these words stem from Proto-Germanic *sunnōn.[24][25] This is ultimately related to the word for sun in other branches of the Indo-European language family, though in most cases a nominative stem with an l is found, rather than the genitive stem in n, as for example in Latin sōl, ancient Greek ἥλιος (hēlios), Welsh haul and Russian солнце (solntse; pronounced sontse), as well as (with *l > r) Sanskrit स्वर (svár) and Persian خور (xvar). Indeed, the l-stem survived in Proto-Germanic as well, as *sōwelan, which gave rise to Gothic sauil (alongside sunnō) and Old Norse prosaic sól (alongside poetic sunna), and through it the words for sun in the modern Scandinavian languages: Swedish and Danish solen, Icelandic sólin, etc.[25]

            The principal adjectives for the Sun in English are sunny for sunlight and, in technical contexts, solar (/ˈsoʊlər/),[3] from Latin sol[26] – the latter found in terms such as solar day, solar eclipse and Solar System (occasionally Sol system). From the Greek helios comes the rare adjective heliac (/ˈhiːliæk/).[27] In English, the Greek and Latin words occur in poetry as personifications of the Sun, Helios (/ˈhiːliəs/) and Sol (/ˈsɒl/),[2][1] while in science fiction Sol may be used as a name for the Sun to distinguish it from other stars. The term sol with a lower-case s is used by planetary astronomers for the duration of a solar day on another planet such as Mars.[28]

            The English weekday name Sunday stems from Old English Sunnandæg "sun's day", a Germanic interpretation of the Latin phrase diēs sōlis, itself a translation of the ancient Greek ἡμέρα ἡλίου (hēmera hēliou) 'day of the sun'.[29] The astronomical symbol for the Sun is a circle with a center dot, ☉. It is used for such units as M☉ (Solar mass), R☉ (Solar radius) and L☉ (Solar luminosity).
        </p>
    </div>
</div>
<div class="row" style="height: 5%" >
    <footer class="text-center bg-primary">
        <h1> Footer </h1>
    </footer>
</div>
<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>
