<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>chart</title>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
</head>
<body>
<h1>This is pie chart.</h1>
<div class="chart-div">
    <canvas id="pieChartCanvas" width="300px" height="300px"></canvas>
</div>
<a href="/excel">엑셀 다운로드</a>
</body>
<script>
    // ------> https://mebadong.tistory.com/20 참고하기

    window.onload = function () {
        pieChartDraw();
    }

    let pieChartData = {
        labels: ['foo', 'bar', 'baz', 'fie', 'foe', 'fee'],
        datasets: [{
            data: [95, 12, 13, 7, 13, 10],
            backgroundColor: ['rgb(255, 99, 132)', 'rgb(255, 159, 64)', 'rgb(255, 205, 86)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)']
        }]
    };

    let pieChartDraw = function () {
        let ctx = document.getElementById('pieChartCanvas').getContext('2d');

        window.pieChart = new Chart(ctx, {
            type: 'pie',
            data: pieChartData,
            options: {
                responsive: false
            }
        });
    };
</script>
</html>