// En Searcher.js

import './Searcher.css';
import { VerticalToggleButtons } from './VerticalToogleButtons';
import { useState } from 'react';
import FixedHeaderTable from '../Table/Table'; 

export const Searcher = () => {
  const [activeButton, setActiveButton] = useState("books");

  const { books, needsReload, getBooks } = useContent(DataBooks);

  useEffect(() => {
    // Cambia el estado de buttonActive a true cuando se carga la página
    setButtonActive(true);
    // Establece el placeholder inicial cuando se carga la página
    setPlaceholder("Búsqueda de libro por título, autor o ISBN");
  }, []);

  const handleUserButtonClick = () => {
    // Maneja la clase del botón de libros de toogleButton a toggleButton-active
    setUserButtonClicked(true);
    setBooksButtonClicked(false);
    setIsUsersActive(true);
    // Cambia el placeholder cuando se hace clic en el botón de usuarios
    setPlaceholder("Buscar socio por nombre, apellido, nº de socio");
  };

  const handleBooksButtonClick = () => {
    // Maneja la clase del botón de socios de toogleButton a toggleButton-active
    setBooksButtonClicked(true);
    setUserButtonClicked(false);
    setIsBooksActive(true);
    // Cambia el placeholder cuando se hace clic en el botón de libros
    setPlaceholder("Búsqueda de libro por título, autor o ISBN");
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
