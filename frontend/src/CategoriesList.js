import Category from "./Category";

const categoriesData = [
  ["Linux", 99],
  ["BASH", 77],
  ["PHP", 181],
  ["Docker", 125],
  ["HTML", 139],
  ["MySQL", 153],
  ["WordPress", 66],
  ["Laravel", 10],
  ["Kubernetes", 136],
  ["JavaScript", 25],
  ["DevOps", 23],
];

function CategoriesList() {
  let categories = categoriesData.map((category) => (
    <Category name={category[0]} count={category[1]}></Category>
  ));
  return (
    <div className="center-h">
      <div className="d-flex flex-row flex-shrink-0 flex-wrap center justify-content-center">
        {categories}
      </div>
    </div>
  );
}

export default CategoriesList;
