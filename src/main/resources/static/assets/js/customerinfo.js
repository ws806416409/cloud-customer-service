$(document).ready(function () {

    //饼图1
    var myPieChart1 = echarts.init(document.getElementById("mainChartPieOne"));
    $.post("/customerInfo/prochart", null, function (data) {
        console.log(data)
        var pieDate = []
        for (var i = 0; i < data.length; i++) {
            pieDate.push(data[i]["level"])
        }
        CountJson = {}
        for (var i = 0; i < pieDate.length; i++) {
            if(CountJson[pieDate[i]] !== undefined){
                CountJson[pieDate[i]]++
            }else{
                CountJson[pieDate[i]] = 1
            }
        }
        //console.log(CountJson)
        var list = []
        for (item in CountJson){
            console.log(item)
            list.push({"value":CountJson[item],"name":item})
        }
        console.log(list)
        option = {
            title: {
                text: '客户类别',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
            },
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '50%',
                    data: list,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myPieChart1.setOption(option);
    }, "json")


    //饼图2
    var myPieChart2 = echarts.init(document.getElementById("mainChartPieTwo"));
    $.post("/customerInfo/prochart", null, function (data) {
        console.log(data)
        var pieDate = []
        for (var i = 0; i < data.length; i++) {
            pieDate.push(data[i]["customername"])
        }
        CountJson = {}
        for (var i = 0; i < pieDate.length; i++) {
            if(CountJson[pieDate[i]] !== undefined){
                CountJson[pieDate[i]]++
            }else{
                CountJson[pieDate[i]] = 1
            }
        }
        //console.log(CountJson)
        var list = []
        for (item in CountJson){
            console.log(item)
            list.push({"value":CountJson[item],"name":item})
        }
        console.log(list)
        option = {
            title: {
                text: '客户来源',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
            },
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '50%',
                    data: list,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myPieChart2.setOption(option);
    }, "json")


})




