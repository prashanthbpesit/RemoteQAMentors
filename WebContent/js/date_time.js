/**
 * 
 */
function dateTimeFunction(id) {
	try {

		var date = new Date;
		var options = {weekday: "long", year: "numeric", month: "long", day: "numeric", hour: "2-digit", minute: "2-digit", second: "2-digit"};
		document.getElementById(id).innerHTML = date.toLocaleTimeString("en-US", options);
		/*months = new Array('January', 'February', 'March', 'April', 'May','June', 'Jully', 'August', 'September', 'October', 'November','December');
		days = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday','Thursday', 'Friday', 'Saturday');
/*		year = date.getFullYear();
		month = date.getMonth();
		d = date.getDate();
		day = date.getDay();
		*h = date.getHours();
		if (h < 10) {
			h = "0" + h;
		}
		m = date.getMinutes();
		if (m < 10) {
			m = "0" + m;
		}
		s = date.getSeconds();
		if (s < 10) {
			s = "0" + s;
		}
		result = '' + days[day] + ' ' + d + ' ' + months[month] + ' ' + year+ ' ' + h + ':' + m + ':' + s;
		*/
		/*var chhous = date.getHours();
		if(chhous >12){
	    	chhous = (date.getHours()-12);
	    } else if (chhous==0){
	    	chhous ='12';
	    }
	    minutes = date.getMinutes().toString().length == 1 ? '0'+date.getMinutes() : date.getMinutes(),
	    hours = chhous.toString().length == 1 ? '0'+chhous : chhous,
	    seconds = date.getSeconds().toString().length == 1 ? '0'+date.getSeconds() : date.getSeconds(),		
	    ampm = date.getHours() >= 12 ? 'PM' : 'AM';
	   // months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'],
	   // days = ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'];
	    result = '' + days[date.getDay()]+', '+months[date.getMonth()]+' '+date.getDate()+' '+date.getFullYear()+', '+hours+':'+minutes+':'+seconds+' '+ampm;		
	   
	    document.getElementById(id).innerHTML = result;*/
		setTimeout('dateTimeFunction("' + id + '");', '1000');
		return true;
	} catch (err) {
	}
}

function getYear(id) {
	try {
		date = new Date;
		year = date.getFullYear();
		document.getElementById(id).innerHTML = "2017 - "+year;
	} catch (err) {
	}
}