import { Header } from "../../components/Header/Header"
import { Searcher } from "../../components/Searcher/Searcher"
import FixedHeaderTable from "../../components/Table/Table"
import { UsersSearcher } from "../../components/Searcher/UsersSearcher"

export const Home = () => {
  return (
    <>
      <Header />
      <Searcher/>
      <FixedHeaderTable />
      <UsersSearcher/>
    </>
  )
}
