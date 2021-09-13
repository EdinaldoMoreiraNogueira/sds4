import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { SaleSum } from 'types/sale';
import { Base_URL } from 'utils/requests';

// eslint-disable-next-line @typescript-eslint/no-unused-vars
type ChartData = {
    labels:string[],
    series:number[],
   
}
function DonutChart() {
    const [chartData, setChartData] = useState<ChartData>({labels: [], series: []})

    useEffect(()=> {

    
    axios.get(`${Base_URL}/sales/sum-by-seller`)
    .then(response => {
        const data = response.data as SaleSum[];
        const myLabels = data.map(x => x.sellerName);
        const mySeries = data.map(x => x.sum);

        console.log(data)

        setChartData({labels: myLabels, series: mySeries});
    })
},[]);
    // const  mockData  =  { 
    //     series : [ 477138 ,  499928 ,  444867 ,  220426 ,  473088 ] , 
    //     labels : [ 'Anakin' ,  'Barry Allen' ,  'Kal-El' ,  'Logan' ,  'Padmé' ] 
    // }
    
    const options = {
        legend: {
            show: true
        }
    }
    return (
       
        <Chart 
        options={{...options, labels: chartData.labels}} 
        series={ chartData.series}
        type='donut'
        height="240"
        />
    );
  }
  
  export default DonutChart;
  