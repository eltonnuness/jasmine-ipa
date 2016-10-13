function () {
    // Enter the JavaScript for the map function here
    // You can access the current document as 'this'
    //
    // Available functions: assert(), BinData(), DBPointer(), DBRef(), doassert(), emit(), gc()
    //                      HexData(), hex_md5(), isNumber(), isObject(), ISODate(), isString()
    //                      Map(), MD5(), NumberInt(), NumberLong(), ObjectId(), print()
    //                      printjson(), printjsononeline(), sleep(), Timestamp(), tojson()
    //                      tojsononeline(), tojsonObject(), UUID(), version()
    //
    // Available properties: args, MaxKey, MinKey
    
    var status = this.status.text;
    if (status){
     	status = status.toLowerCase().split(" ");
     	for(var i = status.length - 1; i >= 0; i--) {
     	  	if(status[i]) {
     	  	 	emit(status[i],1); 
     	  	}
     	}      
    }

}