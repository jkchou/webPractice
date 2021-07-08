//汇总-园林土地资源统计
$(function () {
    Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {

        return {
            radialGradient: {cx: 0.5, cy: 0.3, r: 0.7},
            stops: [
                [0, color],
                [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
            ]
        };
    });
    $('#chart_huizong_tianyuan').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        colors: [
            '#e4393c',//第一个颜色，欢迎加入Highcharts学习交流群294191384
            '#1376C2'//第二个颜色
        ],
        title: {
            text: '地块1土地使用情况'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    formatter: function () {
                        return '<b>' + this.point.name + '</b>: ' + this.percentage + ' %';
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: '面积',
            data: [
                ['已使用', 43.2],
                ['未使用', 56.8]

            ]
        }]
    });
});


//分析-利润评估分析
$(function () {
    $('#chart_lirun').highcharts({
        chart: {
            type: 'area'
        },
        title: {
            text: ''
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: ['2010年', '2011年', '2012年', '2013年', '2014年', '2015年', '2016年'],
            tickmarkPlacement: 'on',
            title: {
                enabled: false
            }
        },
        yAxis: {
            title: {
                text: '百万/元'
            },
            labels: {
                formatter: function () {
                    return this.value / 1000;
                }
            }
        },
        tooltip: {
            shared: true,
            valueSuffix: ' 百万'
        },
        plotOptions: {
            area: {
                stacking: 'normal',
                lineColor: '#666666',
                lineWidth: 1,
                marker: {
                    lineWidth: 1,
                    lineColor: '#666666'
                }
            }
        },
        series: [{
            name: '总利润',
            data: [502, 635, 809, 947, 1402, 3634, 5268]
        }, {
            name: '净利润',
            data: [106, 107, 111, 133, 221, 767, 1766]
        }]
    });
});
//汇总-投产量
$(function () {
    $('#chart_touchanliang').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: ''
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                '2012年',
                '2013年',
                '2014年',
                '2015年',
                '2016年']
        },
        yAxis: {
            min: 0,
            title: {
                text: '投产量（t）'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 吨</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '农药',
            data: [49.9, 71.5, 106.4, 129.2, 144.0]

        }, {
            name: '化肥',
            data: [83.6, 78.8, 98.5, 93.4, 106.0]

        }, {
            name: '种子',
            data: [48.9, 38.8, 39.3, 41.4, 47.0]

        }, {
            name: '其他',
            data: [12.4, 13.2, 14.5, 19.7, 12.6]

        }]
    });
});
//汇总-预产量
$(function () {
    $('#chart_yuchanliang').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: ''
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                '2012年',
                '2013年',
                '2014年',
                '2015年',
                '2016年']
        },
        yAxis: {
            min: 0,
            title: {
                text: '预产量（t）'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 吨</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '21号棚',
            data: [49.9, 71.5, 106.4, 129.2, 144.0]

        }, {
            name: '22号棚',
            data: [83.6, 78.8, 98.5, 93.4, 106.0]

        }, {
            name: '23号棚',
            data: [48.9, 38.8, 39.3, 41.4, 47.0]

        }, {
            name: '24号棚',
            data: [12.4, 13.2, 14.5, 19.7, 12.6]

        }]
    });
});