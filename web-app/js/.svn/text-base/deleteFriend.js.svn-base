function deleteFriend(name,n) {
	id='delete'+n;
	obj = document.getElementById(id);
	inside = obj.innerHTML;
	if (inside=='Delete') {
		obj.innerHTML='Confirm?';
		obj.className='delete button confirm';
	} else if (inside=='Confirm?') {
		obj.innerHTML='Deleted';
		obj.className='delete button deleted';
/* It may be better to make the action something like '"?delete=" + name ' but I leave that to your discretion.
/*		var deleteForm = document.createElement("form");
		deleteForm.method="post";
		deleteForm.action="delete";
		var deleteInput = document.createElement("name");
		deleteInput.setAttribute("name","deletename");
		deleteInput.setAttribute("value",name);
		deleteForm.appendChild(deleteInput);
		document.body.appendChild(deleteForm);
		deleteForm.submit();
		document.body.removeChild(deleteForm);*/
	}
}