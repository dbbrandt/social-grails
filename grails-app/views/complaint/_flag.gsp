<a href="${createLink(controller:'complaint', action:'add', params:[contentId:contentInstance?.id, type:type, content:(type == 'Post')? contentInstance?.description: contentInstance?.description])}" title="Mark this as inappropriate" class="flag iframe"></a>