import './Searcher.css';
import { VerticalToggleButtons } from './VerticalToogleButtons';
import { useState } from 'react';
import Fuse from 'fuse.js';
import axios from 'axios';
import FixedHeaderTable from '../Table/Table';

export const Searcher = () => {
  const [activeButton, setActiveButton] = useState("books");
  const handleButtonChange = (event, newActiveButton) => {
    setActiveButton(newActiveButton);
  };
  const [searchTerm, setSearchTerm] = useState("");
  const [searchResults, setSearchResults] = useState("");

  const handleSearch = async (event) => {
    event.preventDefault(); // Evita que se envíe el formulario y recargue la página
    try {
      const response = await axios.get("http://localhost:9000/books");
      if (response.status === 200) {
        const books = response.data;
        const fuse = new Fuse(books, { keys: ["title", "author", "isbn"] }); // Configura Fuse.js para buscar en los campos "title", "author" e "isbn" de cada libro
        const results = fuse.search(searchTerm); // Realiza la búsqueda
        setSearchResults(results.map(result => result.item));
      } else {
        console.error("Error al obtener datos");
      }
    } catch (error) {
      console.error("Error de red", error);
    }
  };

  return (
    <>
      <section className="searchContainer">
      <form onSubmit={handleSearch}> 
        <div className='searchContainer__Field'>
          <VerticalToggleButtons
            activeButton={activeButton}
            handleButtonChange={handleButtonChange}
          />
          <input
            type="search"
            className="searchContainer__Field-Input"
            placeholder={activeButton === "books" ? "Búsqueda de libro por título, autor o ISBN" : "Buscar socio por nombre, apellido, nº de socio"}
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)} 
          />
          <button type="submit" className="searchContainer__Field-Button"> {/* Utiliza type="submit" para el botón */}
            <img src="/src/assets/searchIcon.svg" alt="búsqueda icono" />
          </button>
        </div>
        </form>
      </section>
      <FixedHeaderTable activeButton={activeButton} searchResults={searchResults} /> Pasa los resultados de la búsqueda como una prop
    </>
  )
}