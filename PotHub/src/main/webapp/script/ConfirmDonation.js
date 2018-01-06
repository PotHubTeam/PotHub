function showProfileDropdown() {
	document.getElementById("profileDropdownDiv").style.display = "block";
}

function hideProfileDropdown() {
	document.getElementById("profileDropdownDiv").style.display = "none";
}

function moveToNext(id, previousID, nextID) {
	id.value = id.value.replace(/[^\d]/g, "");
	
	if (id.value.length > 0) {
		document.getElementById(nextID).focus();
	}
	else {
		document.getElementById(previousID).focus();
	}
}