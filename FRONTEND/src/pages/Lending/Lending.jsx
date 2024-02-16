import './Lending.css'
import { UsersSearcher } from "../../components/Searcher/UsersSearcher"
import { SecondaryHeader } from "../../components/Header/SecondaryHeader"

export const Lending = () => {
  return (
    <div>
      <SecondaryHeader />
      <section className="lending">
        <h2 className="lending__title">Registrar préstamo del libro:</h2>
        <ul className="lending__book">
          <li className="lending__book-text">#1</li>
          <li className="lending__book-text">0124-5478-5789-5</li>
          <li className="lending__book-text">Los últimos balleneros</li>
          <li className="lending__book-text">Doug Bock Clark</li>
        </ul>
        <h2 className="lending__title">Escoger usuario:</h2>
        <UsersSearcher />
      </section>
    </div>
    )
}
