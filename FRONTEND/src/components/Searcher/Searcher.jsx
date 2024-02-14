import { BookIcon } from '../../svg/BookIcon'
import './Searcher.css'

export const Searcher = () => {
  return (
    <section className="searchContainer">
      <div className='searchContainer__Field'>
        <div className='searchContainer__Field-icon'> 
          <BookIcon />
        </div>
        <input
          type="search"
          className="searchContainer__Field-Input"
          placeholder="Búsqueda de libro por título, autor o ISBN"/>
      </div>
    </section>
  )
}
