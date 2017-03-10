var IE = /*@cc_on!@*/false;

/*http://www.leigeber.com/2008/05/sliding-javascript-menu-highlight-1kb/*/
var menuSlider=function(){
	if(IE){
	var m,e,g,s,q,i; e=[]; q=80; i=80;
	}else{
	var m,e,g,s,q,i; e=[]; q=18; i=18;
	}
	return{
		init:function(j,k){
			m=document.getElementById(j); e=m.getElementsByTagName('li');
			var i,l,w,p; i=0; l=e.length;
			for(i;i<l;i++){
				var c,v; c=e[i]; v=c.value; if(v==1){s=c; w=c.offsetWidth; p=c.offsetLeft}
				c.onmouseover=function(){menuSlider.mo(this)}; c.onmouseout=function(){menuSlider.mo(s)};
			}
			g=document.getElementById(k); g.style.width=w+'px'; g.style.left=p+'px';
		},
		mo:function(d){
			clearInterval(m.tm);
			var el,ew; el=parseInt(d.offsetLeft); ew=parseInt(d.offsetWidth);
			m.tm=setInterval(function(){menuSlider.mv(el,ew)},i);
		},
		mv:function(el,ew){
			var l,w; l=parseInt(g.offsetLeft); w=parseInt(g.offsetWidth);
			if(l!=el||w!=ew){
				if(l!=el){var ld,lr,li; ld=(l>el)?-1:1; lr=Math.abs(el-l); li=(lr<q)?ld*lr:ld*q; g.style.left=(l+li)+'px'}
				if(w!=ew){var wd,wr,wi; wd=(w>ew)?-1:1; wr=Math.abs(ew-w); wi=(wr<q)?wd*wr:wd*q; g.style.width=(w+wi)+'px'}
			}else{clearInterval(m.tm)}
}};}();

var status='closed';
function personalStats(action) {
	con=document.getElementById('personal-stats-container');
	ps=document.getElementById('personal-stats');
	tab=document.getElementById('personal-stats-tab');
	cnt=document.getElementById('personal-stats-tab-counter');
	cls=document.getElementById('personal-stats-close-button');
	if (action == 'switch' && status == 'closed') {
		ps.style.height='auto';
		ps.style.position='relative';
		tab.style.position='relative';
		tab.style.top='0';
		cnt.style.display='none';
		cls.style.display='block';
		status='open';
	} else if (action == 'switch' && status == 'open') {
		ps.style.height='9px';
		tab.style.top='15px';
		ps.style.position='absolute';
		ps.style.top='0px';
		cnt.style.display='block';
		cls.style.display='none';
		status='closed';
	} else if (action == 'bumpopen' && status == 'closed') {
		ps.style.height='10px';
		ps.style.paddingTop='6px';
		tab.style.top='15px';
	} else if (action == 'bumpclose' && status == 'closed') {
		ps.style.height='9px';
		ps.style.paddingTop='0px';
		tab.style.top='9px';
	} 
}

function textCounter(field,cntfield,maxlimit) {
	if (field.value.length > maxlimit) // if too long...trim it!
	field.value = field.value.substring(0, maxlimit);
	// otherwise, update 'characters left' counter
	else
	cntfield.value = maxlimit - field.value.length;
}

function submitform(form) {
	document.getElementById(form).submit();
	if (parent.jQuery.fancybox.close()) {
		document.location.reload(true);
	}
}

function submitformNormal(form) {
	document.getElementById(form).submit();
}

function submitformPopup(form) {
	document.getElementById(form).submit();
	parent.jQuery.fancybox.close();
}

function placeholder(input) {
	input.select();
	if (input.style.color != '#000000') {
		input.style.color = '#000000';
	}
}

function hover(elem) {
	if (elem.parentNode.parentNode.className == 'like') {
	if (elem.style.backgroundImage == 'url(images/like-0.gif)') {
	alert(elem.style.backgroundImage);
	}
		/*if (elem.style.backgroundImage == 'url(images/like-0)') {
			alert(elem);
		}*/
	}
}