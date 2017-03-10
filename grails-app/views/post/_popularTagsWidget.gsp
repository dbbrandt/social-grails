<h3>Explore Popular Topics</h3>
<p>
<g:each in="${tagInstanceList}" var="tag">
    <a href="${createLink(controller:'post', action:'tagDirectory', id:tag?.id)}" alt="See more questions tagged ${tag}">${tag}(${tag.postCount})</a>&nbsp;
</g:each>
</p>
