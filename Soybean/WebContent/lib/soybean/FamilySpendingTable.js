/**
 * display the family spending items in a table
 */
$("#spendingTable").jqGrid({
    datatype: "local",
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
$.ajax({
    url: "http://localhost:8080/Soybean/GetFamilySpendingItems",
    type: "get",
    dataType: "json",
    success: function(spendingItems) {
        console.log(spendingItems);
        $.each(spendingItems, function(index, item){
            jQuery("#spendingTable").jqGrid('addRowData',index+1,item);
        });
    },
    error: function(xhr, status, errorThrown) {
        console.log("Errors in getting data from http://localhost:8080/Soybean/GetFamilySpendingItems");
    }
});