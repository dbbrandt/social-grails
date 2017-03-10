<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="mainAdmin"/>
    <title>Menubar example</title>
    <gui:resources components="['menu']"/>

    <style type="text/css">

        /*
            Position and hide the Menu instance to prevent a flash of unstyled
            content when the page is loading.
        */

    div.yuimenu {

        position: absolute;
        visibility: hidden;

    }

        /*
            Set the "zoom" property to "normal" since it is set to "1" by the
            ".example-container .bd" rule in yui.css and this causes a Menu
            instance's width to expand to 100% of the browser viewport.
        */

    div.yuimenu .bd {

        zoom: normal;

    }

    .yui-skin-sam .yuimenubar {
        border: 1px solid #808080;
        font-size: 93%;
        line-height: 2;
    }

    </style>

</head>

<body class='yui-skin-sam'>

<h1>Menubar Demo</h1>

<h2>Menubar applied to document.body</h2>
<p/>This is the default behavior, as seen at the top of the screen.

<div>
    <gui:menubar id='myMenubar'>
        <gui:menuitem url='http://example.com'>Example</gui:menuitem>
        <gui:submenu label='Foodstuffs'>
            <gui:menuitem url='http://campbells.com'>Campbell's Soup</gui:menuitem>
            <gui:menuitem url='http://cheetos.com'>Cheetos</gui:menuitem>
            <gui:menuitem url='http://guiness.com'>Guiness</gui:menuitem>
        </gui:submenu>
        <!-- mega nesting! -->
        <g:each var="mainCnt" in="${(1..3)}">
            <gui:submenu label="Nest Menu ${mainCnt}">
                <g:each var="nest1" in="${(1..3)}">
                    <gui:menuitem url="http://example.com">Menu Item ${nest1}</gui:menuitem>
                </g:each>
                <g:each var="nest1" in="${(1..3)}">
                    <gui:submenu label="Nest Menu ${mainCnt}">
                        <g:each var="nest2" in="${(1..3)}">
                            <gui:menuitem url="http://example.com" helpText="Ctrl-E">Menu Item ${nest2}</gui:menuitem>
                        </g:each>
                        <g:each var="nest2" in="${(1..3)}">
                            <gui:submenu label="Nest Menu ${mainCnt}">
                                <g:each var="nest3" in="${(1..3)}">
                                    <gui:menuitem url="http://example.com">Menu Item ${nest3}</gui:menuitem>
                                </g:each>
                            </gui:submenu>
                        </g:each>
                        <g:each var="nest2" in="${(4..6)}">
                            <gui:menuitem url="http://example.com">Menu Item ${nest2}</gui:menuitem>
                        </g:each>
                    </gui:submenu>
                </g:each>
                <g:each var="nest1" in="${(4..6)}">
                    <gui:menuitem url="http://example.com">Menu Item ${nest1}</gui:menuitem>
                </g:each>
            </gui:submenu>
        </g:each>
        <gui:submenu label='Shoes'>
            <gui:menuitem url='http://nike.com'>Nike</gui:menuitem>
            <gui:menuitem url='http://reebok.com'>Reebok</gui:menuitem>
            <gui:menuitem url='http://adidas.com'>Adidas</gui:menuitem>
        </gui:submenu>
        <gui:submenu id="outerSubmenu" label="Search Engines">
            <gui:menuitem url='http://yahoo.com'>Yahoo</gui:menuitem>
            <gui:submenu id="innerSubmenu" label='Google Search Results'>
                <gui:menuitem url='http://google.com/search?q=yahoo'>Google on Yahoo</gui:menuitem>
                <gui:menuitem url='http://google.com/search?q=msn'>Google on MSN</gui:menuitem>
                <gui:menuitem url='http://google.com/search?q=google'>Google on Google</gui:menuitem>
            </gui:submenu>
            <gui:menuitem url='http://msn.com'>MSN</gui:menuitem>
        </gui:submenu>
    </gui:menubar>

    <h2>MenuBar applied inside a container</h2>
    <p/>You can also apply a menubar to a container as seen below.  But if you have multiple menus on the same page, make sure they all have unique ids (or no ids, because grails-ui will generate them if you don't supply them).
    <p/>This menubar is also taking advantage of some of the YUI Menubar config options (autosubmenudisplay, submenualignment).
    <div id='innerDiv' style="width: 600px; margin:20px, 200px; border: 1px solid black">
        <div id='innerMenu'></div>
        <div style="padding:10px">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer faucibus est sed ligula. Proin venenatis. Nulla a justo. Mauris sed ipsum. Duis nisi nibh, vehicula sit amet, congue quis, tristique ut, tortor. Sed luctus orci quis odio. Curabitur placerat semper felis. Sed lobortis, mi at lobortis posuere, ante pede hendrerit erat, eget volutpat ante libero tempus turpis. Integer fermentum, elit gravida semper venenatis, lectus dui gravida ipsum, vel faucibus ante sem vel lectus. Vivamus quis metus quis elit ultrices lacinia. Proin vel neque quis libero viverra luctus.

Phasellus fringilla vestibulum tortor. Maecenas rhoncus congue purus. Proin eu pede eu elit bibendum fermentum. Duis eu ligula. Mauris sit amet tellus. Sed erat lorem, pharetra ut, imperdiet vitae, interdum id, libero. Donec pellentesque pharetra turpis. Integer et tellus. Donec et augue. Morbi mollis, ligula nec consequat tempus, arcu pede tincidunt felis, a tristique purus velit euismod orci. Maecenas justo elit, consectetur a, malesuada non, sodales at, justo. Nullam orci. Maecenas dictum velit ac purus. Nullam congue lacus vitae diam. Nam porttitor, urna tempus tempor tincidunt, lorem dolor imperdiet turpis, sed varius odio dui eget tellus.
        </div>
    </div>

<gui:menubar id='myInnerMenubar' renderTo='innerMenu'>
    <gui:menuitem url='http://example.com'>Example</gui:menuitem>
    <gui:submenu label='Foodstuffs'>
        <gui:menuitem url='http://campbells.com'>Campbell's Soup</gui:menuitem>
        <gui:menuitem url='http://cheetos.com'>Cheetos</gui:menuitem>
        <gui:menuitem url='http://guiness.com'>Guiness</gui:menuitem>
    </gui:submenu>
    <gui:submenu label='Shoes'>
        <gui:menuitem url='http://nike.com'>Nike</gui:menuitem>
        <gui:menuitem url='http://reebok.com'>Reebok</gui:menuitem>
        <gui:menuitem url='http://adidas.com'>Adidas</gui:menuitem>
    </gui:submenu>
    <gui:submenu id="outerSubmenu2" label="Search Engines">
        <gui:menuitem url='http://yahoo.com'>Yahoo</gui:menuitem>
        <gui:submenu id="innerSubmenu2" label='Google Search Results'>
            <gui:menuitem url='http://google.com/search?q=yahoo'>Google on Yahoo</gui:menuitem>
            <gui:menuitem url='http://google.com/search?q=msn'>Google on MSN</gui:menuitem>
            <gui:menuitem url='http://google.com/search?q=google'>Google on Google</gui:menuitem>
        </gui:submenu>
        <gui:menuitem url='http://msn.com'>MSN</gui:menuitem>
    </gui:submenu>
</gui:menubar>

</div>

</body>
</html>