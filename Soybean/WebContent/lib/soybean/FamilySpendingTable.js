/**
 * display the family spending items in a table
 */
$("#spendingTable").jqGrid({
    url: "http://localhost:8080/Soybean/GetFamilySpendingItems",
	datatype: "json",
    height: 250,
    colNames:['No','Date', 'Amount','Description','Category','Pay Method', "Spender"],
    colModel:[
        {name:'id',index:'id', width:60, sorttype:"int", editable:false,editoptions:{readonly:true,size:10}},
        {name:'date',index:'date', width:90, sorttype:"date", editable:true,editoptions:{size:10}},
        {name:'amount',index:'amount', width:100, sorttype: "float", editable:true,editoptions:{size:10}},
        {name:'description',index:'description', width:80, align:"right", sortable: false, editable:true,editoptions:{size:10}},
        {name:'category',index:'category', width:80, align:"right", sorttype:"string", editable:true,editoptions:{size:10}},
        {name:'paymentMethod',index:'paymentMethod', width:80,align:"right",sorttype:"string", editable:true,editoptions:{size:10}},
        {name:'name',index:'name', width:150, sortable:false}
    ],
    multiselect: false,
    caption: "Family Spending Details"
});