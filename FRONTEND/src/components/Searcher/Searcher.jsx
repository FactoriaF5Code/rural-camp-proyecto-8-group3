import './Searcher.css';
import { VerticalToggleButtons } from './VerticalToogleButtons';
import { useState, useEffect } from 'react';

export const Searcher = () => {
  const [buttonActive, setButtonActive] = useState(false);
  const [userButtonClicked, setUserButtonClicked] = useState(false);
  const [booksButtonClicked, setBooksButtonClicked] = useState(false);
  const [isUsersActive, setIsUsersActive] = useState(false);
  const [isBooksActive, setIsBooksActive] = useState(true);
  const [placeholder, setPlaceholder] = useState('');

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
    <section className="searchContainer">
      <div className='searchContainer__Field'>
      <VerticalToggleButtons
        buttonActive={buttonActive}
        userButtonClicked={userButtonClicked}
        handleBooksButtonClick={handleBooksButtonClick}
        booksButtonClicked={booksButtonClicked}
        handleUserButtonClick={handleUserButtonClick}/>
        <input
          type="search"
          className="searchContainer__Field-Input"
          placeholder={placeholder} // Utiliza el placeholder dinámico
        />
        <button className="searchContainer__Field-Button">
          <img src="/src/assets/searchIcon.svg" alt="búsqueda icono" />
        </button>        
      </div>
    </section>
  )
}
