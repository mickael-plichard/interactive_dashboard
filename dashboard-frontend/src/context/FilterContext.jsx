import {createContext, useContext, useState} from "react";


const FilterContext = createContext();

export function FilterProvider({ children }) {
    const [category, setCategory] = useState('');

    return (
        <FilterContext.Provider value={{ category, setCategory }}>
            {children}
        </FilterContext.Provider>
    );
}

export function useFilter() {
    return useContext(FilterContext);
}