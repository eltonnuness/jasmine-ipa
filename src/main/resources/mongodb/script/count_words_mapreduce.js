// *** 3T Software Labs, MongoChef: MapReduce Job ****

// Variable for map
var __3t_mongochef_map = function () {
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
;

// Variable for reduce
var __3t_mongochef_reduce = function (key, values) {

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
;

db.runCommand({ 
    mapReduce: "usertwitterdata",
    map: __3t_mongochef_map,
    reduce: __3t_mongochef_reduce,
    out: { "reduce" : "words_count" , "sharded" : false , "nonAtomic" : false},
    query: { },
    sort: { },
    inputDB: "jasmine-data",
 });
