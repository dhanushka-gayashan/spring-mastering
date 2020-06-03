const decodeChartData = (chartData) => {
    const txt = document.createElement("textarea")
    txt.innerHTML = chartData
    return txt.value
}

const labelData = []
const countData = []
JSON.parse(decodeChartData(chartData)).forEach((data) => {
    labelData.push(data.label)
    countData.push(data.value)
})

const pieChart = new Chart(document.getElementById("pieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'Chart Dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            borderColor: 'rgb(255,99,132)',
            data: countData
        }]
    },
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }
    }
});


