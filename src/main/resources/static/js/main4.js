/**
 *
 * Active Charts using Highcharts demonstration
 *
 * Licensed under the MIT license.
 * http://www.opensource.org/licenses/mit-license.php
 *
 * Copyright 2012, Script Tutorials
 * http://www.script-tutorials.com/
 */

// Change Chart type function
function ChangeChartType(chart, series, newType) {
    newType = newType.toLowerCase();
    for (var i = 0; i < series.length; i++) {
        var srs = series[0];
        try {
            srs.chart.addSeries({
                    type: newType,
                    stack: srs.stack,
                    yaxis: srs.yaxis,
                    name: srs.name,
                    color: srs.color,
                    data: srs.options.data
                },
                false);
            series[0].remove();
        } catch (e) {
        }
    }
}

// Two charts definition
var chart1;
// Once DOM (document) is finished loading
$(document).ready(function () {

    // First chart initialization
    chart1 = new Highcharts.Chart({
        chart: {
            renderTo: 'chart_5',
            type: 'spline',
            height: 350
        },
        title: {
            text: '',
            x: -20,
            style: {
                color: '#666'
            }
        }, subtitle: {
            text: '',
            x: -20
        },

        xAxis: {
            categories: ['12日', '13日', '14日', '15日', '16日', '17日', '18日', '19日'],
            labels: {
                style: {
                    color: '#666'
                }
            }
        },
        yAxis: [{

            title: {
                text: '温 度（°C）',
                style: {
                    color: '#666'
                }
            }, plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }],
            labels: {
                style: {
                    color: '#666'
                }
            }
        }, {
            title: {
                text: '二 氧 化 碳 浓 度 （ppm）',
                style: {
                    color: '#666'
                }
            }, plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }], labels: {
                style: {
                    color: '#666'
                }
            }
        }, {
            title: {
                text: '湿 度（%）',
                style: {
                    color: '#666'
                }
            }, plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }], labels: {
                style: {
                    color: '#666'
                }
            }
            , opposite: true
        }, {
            title: {
                text: '光 照（lum）',
                style: {
                    color: '#666'
                }
            }, plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }], labels: {
                style: {
                    color: '#666'
                }
            },
            opposite: true
        }],

        series: [{
            name: '空气温度',
            data: [5, 10, 20, 22, 25, 28, 30, 20],
            yAxis: 0,//与yAxis第几个对应从0开始
            tooltip: {
                valueSuffix: 'ppm'//预览窗口设对应单位
            }
        }, {
            name: '空气湿度',
            data: [15, 15, 18, 40, 30, 25, 50, 15],
            yAxis: 2,
            tooltip: {
                valueSuffix: '%'
            }
        }, {
            name: '土壤温度',
            data: [1, 3, 6, 0, 50, 25, 50, 50]
        }, {
            name: '土壤水分',
            data: [5, 10, 6, 17, 10, 25, 30, 10]
        }, {
            name: '二氧化碳浓度',
            data: [3, 10, 21, 8, 30, 15, 42, 9],
            yAxis: 1,
            tooltip: {
                valueSuffix: 'ppm'
            }
        }, {
            name: '光照',
            data: [3, 3, 10, 0, 50, 25, 15, 8],
            yAxis: 3,
            tooltip: {
                valueSuffix: 'lum'
            }

        }
        ]
    });


});