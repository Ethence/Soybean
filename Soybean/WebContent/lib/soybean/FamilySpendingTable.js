/**
 * display the family spending items in a table
 */
$("#spendingTable").jqGrid({
    datatype: "local",
    height: 250,
    colNames:['No','Date', 'Amount','Description','Category','Pay Method', "Spender"],
    colModel:[
        {name:'id',index:'id', width:60, sorttype:"int"},
        {name:'date',index:'date', width:90, sorttype:"date"},
        {name:'amount',index:'amount', width:100, sorttype: "float"},
        {name:'description',index:'description', width:80, align:"right", sortable: false},
        {name:'category',index:'category', width:80, align:"right", sorttype:"string"},
        {name:'paymentMethod',index:'paymentMethod', width:80,align:"right",sorttype:"string"},
        {name:'name',index:'name', width:150, sortable:false}
    ],
    multiselect: true,
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