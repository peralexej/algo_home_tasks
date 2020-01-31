defmodule Tester do

  @spec run(string) :: string
  def run(path \\ "testingFolder") do
    case File.ls(path)  do
      {:ok, files}
        ->
          Enum.map(files, fn file -> calculate_and_save(file, path) end)
      {:error, reason} -> IO.puts reason
    end
  end

  def calculate_and_save(file, path) do
    if String.contains?(file, ".in")do
      case File.read("#{path}/#{file}") do
        {:ok, binary}
        ->
          save_to_file("#{path}/#{file}", String.length(binary))
        {:error, _reason} -> "That file doesn't exist"
      end
    end
  end

  def save_to_file(file_name, len) do
    output_file = String.replace(file_name, ".in", ".out")
    File.write!(output_file, "#{len}")
  end
end