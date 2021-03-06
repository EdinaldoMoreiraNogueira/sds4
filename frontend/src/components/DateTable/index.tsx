import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { Base_URL } from "utils/requests";

function DateTable() {

    const[activePage, setActivePage] = useState(0)
    const[page, setPage] = useState<SalePage>({

        first: true,
        last: true,
        number: 0,
        totalElements:0,
        totalPages:0,

    });
     useEffect(()=>{
       axios.get(`${Base_URL}/sales?page=${activePage}&size=20&sort=date,desc`)
       .then(response => {
        setPage(response.data)
    })
},[activePage]);
    const chargePage = (index:number) => {
        setActivePage(index);
    }

    return (
        <>
        <Pagination page={page} onPageChange={chargePage}/>
        < div  className = " table-responsive " > 
        < table  className = " table table-striped table-sm " > 
            < thead > 
                < tr > 
                    < th > Dados </ th > 
                    < th > Vendedor </ th > 
                    < th > Clientes contrato </ th > 
                    < th > Negócios fechados </ th > 
                    <th > Valor</ th > 
                </ tr > 
            </ thead > 
            < tbody > 
            {page.content?.map(item => (
                 < tr key={item.id} > 
                 < td > {formatLocalDate(item.date, "dd/MM/yyy")} </ td > 
                 < td > {item.seller.name} </ td > 
                 < td > {item.visited} </ td > 
                 < td >{item.deals} </ td > 
                 < td > {item.amount.toFixed(2)} </ td > 
             </ tr > 
            ))
              
            }
            </ tbody >
        </ table > 
    </ div >
        </>
    );
  }
  
  export default DateTable;
  