<g:select id="category" name="category" from="${categoryTags}" optionKey="id" value="${category?.id}" noSelection="['null': 'Category...']" 
        onchange="${remoteFunction(
            controller:'tag', 
            action:'getTags', 
            params:'\'category=\' + escape(this.value)',
            update:'tagQuestion')}"
/>
<g:select id="topic" name="topic" from="${topicTags}" optionKey="id" value="${topic?.id}" noSelection="['null': 'Topic...']" 
        onchange="${remoteFunction(
            controller:'tag', 
            action:'getTags', 
            params:'\'topic=\' + escape(this.value)',
            update:'tagQuestion')}"
/>
<g:select name="subtopic" from="${subtopicTags}" optionKey="id" value="${subtopic?.id}" noSelection="['null': 'Subtopic...']" 
        onchange="${remoteFunction(
            controller:'tag', 
            action:'getTags', 
            params:'\'subtopic=\' + escape(this.value)',
            update:'tagQuestion')}"
/>
<g:select name="usertag" from="${userTags}" optionKey="id" value="${userTag?.id}" noSelection="['null': 'Choose a tag..']" />
<a href="[ADD TAG SET LINK]" style="position:absolute;left:15px;top:33px;color:#9AB1C9;">Add Tag Set</a>
<a href="popups/create-tag-popup.html" id="create-tag-link" style="position:absolute;left:533px;top:33px">Or create your own tag</a>
