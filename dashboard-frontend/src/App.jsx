import {useEffect, useState} from "react";
import ChartComponent from "./ChartComponent.jsx";


function App() {
    const [data, setData] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8000/api/dashboard/')
            .then(res => res.json())
            .then(data => setData(data))
            .catch(err => console.log('Erreur: ' , err));
    }, []);

    return (
        <div style={{ padding: '20px' }}>
            <h1>Dashboard</h1>
            {data.length > 0 ? (
                <ChartComponent data={data} />
            ) : (
                <p>Loading...</p>
            )}
        </div>
    );
}

export default App;