function (key, values) {

    // Enter the JavaScript for the reduce function here
    // 'values' is a list of objects as emit()'ed by the map() function
    // Make sure the object your return is of the same type as the ones emit()'ed
    //
    // Available functions: assert(), BinData(), DBPointer(), DBRef(), doassert(), emit(), gc()
    //                      HexData(), hex_md5(), isNumber(), isObject(), ISODate(), isString()
    //                      Map(), MD5(), NumberInt(), NumberLong(), ObjectId(), print()
    //                      printjson(), printjsononeline(), sleep(), Timestamp(), tojson()
    //                      tojsononeline(), tojsonObject(), UUID(), version()
    //
    // Available properties: args, MaxKey, MinKey

	var count = 0;
	
	values.forEach(function(v) {
	  count +=v;
	});

    return count;
}