<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="mainAdmin" />
    <title>Menu example</title>
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

</style>


</head>

<body class='yui-skin-sam'>

    <h1>Menu Demo</h1>

    <h2>Basic Menu</h2>
    <p/>This menu has untitled groups, titled groups, and submenus.  It is initially hidden, and shown by a button click with a listener on the page.
    <div style="width:200px">
<gui:menu id='myMenu'>
    <gui:menuitem url='http://example.com'>Example</gui:menuitem>
    <!-- Grouped and titled -->
    <gui:menugroup title='Foodstuffs'>
        <gui:menuitem url='http://campbells.com'>Campbell's Soup</gui:menuitem>
        <gui:menuitem url='http://cheetos.com'>Cheetos</gui:menuitem>
        <gui:menuitem url='http://guiness.com'>Guiness</gui:menuitem>
    </gui:menugroup>
    <!-- Grouped, no title -->
    <gui:menugroup>
        <gui:menuitem url='http://nike.com'>Nike</gui:menuitem>
        <gui:menuitem url='http://reebok.com'>Reebok</gui:menuitem>
        <gui:menuitem url='http://adidas.com'>Adidas</gui:menuitem>
    </gui:menugroup>
    <!-- Submenu -->
    <gui:submenu id="outerSubmenu" label="Search Engines">
        <gui:menuitem url='http://yahoo.com'>Yahoo</gui:menuitem>
        <gui:submenu id="innerSubmenu" label='Google Search Results'>
            <gui:menuitem url='http://google.com/search?q=yahoo'>Google on Yahoo</gui:menuitem>
            <gui:menuitem url='http://google.com/search?q=msn'>Google on MSN</gui:menuitem>
            <gui:menuitem url='http://google.com/search?q=google'>Google on Google</gui:menuitem>
        </gui:submenu>
        <gui:menuitem url='http://msn.com'>MSN</gui:menuitem>
    </gui:submenu>
</gui:menu>
        <button type="button" id='showTrigger'>Show Menu</button>
        <script>
            YAHOO.util.Event.onDOMReady(function() {
                YAHOO.util.Event.addListener("showTrigger", "click", GRAILSUI.myMenu.show, null, GRAILSUI.myMenu);
            });
        </script>
    </div>

</body>
</html>