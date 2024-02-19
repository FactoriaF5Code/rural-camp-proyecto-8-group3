import './Searcher.css';
import { VerticalToggleButtons } from './VerticalToogleButtons';
import { useState } from 'react';
import FixedHeaderTable from '../Table/Table';
export const Searcher = () => {
  const [activeButton, setActiveButton] = useState("books");
  const handleButtonChange = (event, newActiveButton) => {
    setActiveButton(newActiveButton);
  };
  return (
    <>
      <section className="searchContainer">
        <div className='searchContainer__Field'>
          <VerticalToggleButtons
            activeButton={activeButton}
            handleButtonChange={handleButtonChange}
          />
          <input
            type="search"
            className="searchContainer__Field-Input"
            placeholder={activeButton === "books" ? "Búsqueda de libro por título, autor o ISBN" : "Buscar socio por nombre, apellido, nº de socio"}
          />
          <button className="searchContainer__Field-Button">
            <img src="/src/assets/searchIcon.svg" alt="búsqueda icono" />
          </button>
        </div>
      </section>
      <FixedHeaderTable activeButton={activeButton} />
    </>
  )
}