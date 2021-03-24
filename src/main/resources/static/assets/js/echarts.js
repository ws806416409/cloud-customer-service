$(document).ready(function () {
    var myChart = echarts.init(document.getElementById("mainChart"));
    $.post("/workloadStatistics/details", null, function (data) {
        var nameData=[]
        var xData=[]
        for(var i=0;i<data.length;i++){
            nameData.push(data[i]['nickname'])
            xData.push(data[i]["totalsessioncount"])
        }
        var option = {
            title: {
                text: "工作量统计"
            },
            tooltip: {
                trigger: "axis",
                axisPointer: {
                    type: "shadow"
                }
            },

            xAxis: {
                name: "客服名",
                type: "category",
                data: nameData,
                axisTick: {
                    alignWithLabel: true
                }
            },
            yAxis: {
                name: "会话数",
                type: "value"
            },
            series: [{
                data: xData,
                type: "bar",
                barWidth: "80%"
            }],
            dataZoom: [{
                type: "inside"
            }, {
                type: "slider"
            }]
        };

        myChart.setOption(option);


    }, "json")
})


